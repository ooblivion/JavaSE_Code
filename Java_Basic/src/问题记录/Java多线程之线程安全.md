## 什么是线程安全和线程不安全

- 线程安全就是多线程访问时，采用了加锁机制，当一个线程访问该类的某个数据时，进行保护，其他线程不能进行访问直到该线程读取完，其他线程才可使用。不会出现数据不一致或者数据污染。
- 线程不安全就是不提供数据访问保护，有可能出现多个线程先后更改数据造成所得到的数据是脏数据。

## java内置的线程锁机制

### 关键字synchronized

- synchronized是java中的一个关键字，也就是说是Java语言内置的特性。

- 实现方式

  ```java
  synchronized( 需要一个任意的对象（锁） ){
  代码块中放操作共享数据的代码。
  }
  ```

- synchronized的缺陷
  - 如果一个代码块被synchronized修饰了，当一个线程获取了对应的锁，并执行该代码块时，其他线程便只能一直等待，等待获取锁的线程释放锁，而这里获取锁的线程释放锁只会有两种情况：
    - 获取锁的线程执行完了该代码块，然后线程释放对锁的占有；
    - 线程执行发生异常，此时JVM会让线程自动释放锁。
  - 例子1：
    - 如果这个获取锁的线程由于要等待IO或者其他原因（比如调用sleep方法）被阻塞了，但是又没有释放锁，其他线程便只能干巴巴地等待，试想一下，这多么影响程序执行效率。
    - 因此就需要有一种机制可以不让等待的线程一直无期限地等待下去（比如只等待一定的时间或者能够响应中断），通过Lock就可以办到。
  - 例子2：
    - 当有多个线程读写文件时，读操作和写操作会发生冲突现象，写操作和写操作会发生冲突现象，但是读操作和读操作不会发生冲突现象。
    - 但是采用synchronized关键字来实现同步的话，就会导致一个问题：如果多个线程都只是进行读操作，当一个线程在进行读操作时，其他线程只能等待无法进行读操作。
      - 因此就需要一种机制来使得多个线程都只是进行读操作时，线程之间不会发生冲突，通过Lock就可以办到。
      - 另外，通过Lock可以知道线程有没有成功获取到锁。这个是synchronized无法办到的。
      - 总的来说，也就是说Lock提供了比synchronized更多的功能。

### Lock

- 首先要说明的就是Lock，通过查看Lock的源码可知，Lock是一个接口

```java
public interface Lock {
    void lock();
    void lockInterruptibly() throws InterruptedException;
    boolean tryLock();
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
    void unlock();
    }
```

- Lock接口中每个方法的使用:
  - `lock()、tryLock()、tryLock(long time, TimeUnit unit)、lockInterruptibly()`是用来获取锁的。
  - `unLock()`方法是用来释放锁的。
- 四个获取锁方法的区别：
  - lock()方法
    - 是平常使用得最多的一个方法，就是用来获取锁。如果锁已被其他线程获取，则进行等待。
    - 由于在前面讲到如果采用Lock，必须主动去释放锁，并且在发生异常时，不会自动释放锁。因此一般来说，使用Lock必须在try{}catch{}块中进行，并且将释放锁的操作放在finally块中进行，以保证锁一定被被释放，防止死锁的发生。
  - tryLock()方法
    - 是有返回值的，它表示用来尝试获取锁，如果获取成功，则返回true，如果获取失败（即锁已被其他线程获取），则返回false，也就说这个方法无论如何都会立即返回。在拿不到锁时不会一直在那等待。
  - tryLock(long time, TimeUnit unit)方法
    - 和tryLock()方法是类似的，只不过区别在于这个方法在拿不到锁时会等待一定的时间，在时间期限之内如果还拿不到锁，就返回false。如果如果一开始拿到锁或者在等待期间内拿到了锁，则返回true。
  - lockInterruptibly()方法
    - 比较特殊，当通过这个方法去获取锁时，如果线程正在等待获取锁，则这个线程能够响应中断，即中断线程的等待状态。也就使说，当两个线程同时通过lock.lockInterruptibly()想获取某个锁时，假若此时线程A获取到了锁，而线程B只有等待，那么对线程B调用threadB.interrupt()方法能够中断线程B的等待过程。
    - 注意，当一个线程获取了锁之后，是不会被interrupt()方法中断的。
    - 因此当通过lockInterruptibly()方法获取某个锁时，如果不能获取到，只有进行等待的情况下，是可以响应中断的。
    - 而用synchronized修饰的话，当一个线程处于等待某个锁的状态，是无法被中断的，只有一直等待下去。
- Lock和synchronized的区别
  - Lock不是Java语言内置的，synchronized是Java语言的关键字，因此是内置特性。Lock是一个类，通过这个类可以实现同步访问；
  - Lock和synchronized有一点非常大的不同，采用synchronized不需要用户去手动释放锁，当synchronized方法或者synchronized代码块执行完之后，系统会自动让线程释放对锁的占用；而Lock则必须要用户去手动释放锁，如果没有主动释放锁，就有可能导致出现死锁现象。

#### ReentrantLock

- 直接使用lock接口的话，我们需要实现很多方法，不太方便，ReentrantLock是唯一实现了Lock接口的类，并且ReentrantLock提供了更多的方法，ReentrantLock，意思是“可重入锁”。

##### lock()的使用方法

```csharp
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLockTest {
    private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    static Lock lock = new ReentrantLock(); // 注意这个地方
    public static <E> void main(String[] args) {
        new Thread() {
            public void run() {
                Thread thread = Thread.currentThread();
                
                lock.lock();
                try {
                    System.out.println(thread.getName() + "得到了锁");
                    for (int i = 0; i < 5; i++) {
                        arrayList.add(i);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                } finally {
                    System.out.println(thread.getName() + "释放了锁");
                    lock.unlock();
                }

            };
        }.start();
        
        new Thread() {
            public void run() {
                Thread thread = Thread.currentThread();
                lock.lock();
                try {
                    System.out.println(thread.getName() + "得到了锁");
                    for (int i = 0; i < 5; i++) {
                        arrayList.add(i);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                } finally {
                    System.out.println(thread.getName() + "释放了锁");
                    lock.unlock();
                }

            };
        }.start();
    }

}
```

##### tryLock()的使用方法

```csharp
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 观察现象：一个线程获得锁后，另一个线程取不到锁，不会一直等待
 * @author
 *
 */
public class MyTryLock {

    private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    static Lock lock = new ReentrantLock(); // 注意这个地方
    public static void main(String[] args) {
        
        new Thread() {
            public void run() {
                Thread thread = Thread.currentThread();
                boolean tryLock = lock.tryLock();
                System.out.println(thread.getName()+" "+tryLock);
                if (tryLock) {
                    try {
                        System.out.println(thread.getName() + "得到了锁");
                        for (int i = 0; i < 5; i++) {
                            arrayList.add(i);
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    } finally {
                        System.out.println(thread.getName() + "释放了锁");
                        lock.unlock();
                    }
                }
            };
        }.start();

        new Thread() {
            public void run() {
                Thread thread = Thread.currentThread();
                boolean tryLock = lock.tryLock();
                System.out.println(thread.getName()+" "+tryLock);
                if (tryLock) {
                    try {
                        System.out.println(thread.getName() + "得到了锁");
                        for (int i = 0; i < 5; i++) {
                            arrayList.add(i);
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    } finally {
                        System.out.println(thread.getName() + "释放了锁");
                        lock.unlock();
                    }
                }

            };
        }.start();
    }


}
```

##### lockInterruptibly()响应中断的使用方法

```csharp
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 观察现象：如果thread-0得到了锁，阻塞。。。thread-1尝试获取锁，如果拿不到，则可以被中断等待
 * @author
 *
 */
public class MyInterruptibly {
     private Lock lock = new ReentrantLock();  
     
        public static void main(String[] args)  {
            MyInterruptibly test = new MyInterruptibly();
            MyThread thread0 = new MyThread(test);
            MyThread thread1 = new MyThread(test);
            thread0.start();
            thread1.start();
             
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread1.interrupt();
            System.out.println("=====================");
        }  
         
        public void insert(Thread thread) throws InterruptedException{
            lock.lockInterruptibly();   //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出
            try {  
                System.out.println(thread.getName()+"得到了锁");
                long startTime = System.currentTimeMillis();
                for(    ;     ;) {
                    if(System.currentTimeMillis() - startTime >= Integer.MAX_VALUE)
                        break;
                    //插入数据
                }
            }
            finally {
                System.out.println(Thread.currentThread().getName()+"执行finally");
                lock.unlock();
                System.out.println(thread.getName()+"释放了锁");
            }  
        }
    }
     
    class MyThread extends Thread {
        private MyInterruptibly test = null;
        public MyThread(MyInterruptibly test) {
            this.test = test;
        }
        @Override
        public void run() {
             
            try {
                test.insert(Thread.currentThread());
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName()+"被中断");
            }
        }

}
```

### ReadWriteLock读写锁

- ReadWriteLock也是一个接口，在它里面只定义了两个方法

  ```java
  public interface ReadWriteLock {
  /**
  * Returns the lock used for reading.
  *
  * @return the lock used for reading.
  */
  Lock readLock();
  ```

  ```java
  /**
   * Returns the lock used for writing.
   *
   * @return the lock used for writing.
   */
  
  ```

- 一个用来获取读锁，一个用来获取写锁。也就是说将文件的读写操作分开，分成2个锁来分配给线程，从而使得多个线程可以同时进行读操作。

#### ReentrantReadWriteLock

- ReentrantReadWriteLock里面提供了很多丰富的方法，不过最主要的有两个方法：readLock()和writeLock()用来获取读锁和写锁。



```csharp
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁，可以实现读写分离锁定，读操作并发进行，写操作锁定单个线程
 * 
 * 如果有一个线程已经占用了读锁，则此时其他线程如果要申请写锁，则申请写锁的线程会一直等待释放读锁。
 * 如果有一个线程已经占用了写锁，则此时其他线程如果申请写锁或者读锁，则申请的线程会一直等待释放写锁。
 * @author
 *
 */
public class MyReentrantReadWriteLock {
     private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
     
        public static void main(String[] args)  {
            final MyReentrantReadWriteLock test = new MyReentrantReadWriteLock();
             
            new Thread(){
                public void run() {
                    test.get(Thread.currentThread());
                    test.write(Thread.currentThread());
                };
            }.start();
             
            new Thread(){
                public void run() {
                    test.get(Thread.currentThread());
                    test.write(Thread.currentThread());
                };
            }.start();
             
        }  
        
        /**
         * 读操作,用读锁来锁定
         * @param thread
         */
        public void get(Thread thread) {
            rwl.readLock().lock();
            try {
                long start = System.currentTimeMillis();
                 
                while(System.currentTimeMillis() - start <= 1) {
                    System.out.println(thread.getName()+"正在进行读操作");
                }
                System.out.println(thread.getName()+"读操作完毕");
            } finally {
                rwl.readLock().unlock();
            }
        }

        /**
         * 写操作，用写锁来锁定
         * @param thread
         */
        public void write(Thread thread) {
            rwl.writeLock().lock();;
            try {
                long start = System.currentTimeMillis();
                 
                while(System.currentTimeMillis() - start <= 1) {
                    System.out.println(thread.getName()+"正在进行写操作");
                }
                System.out.println(thread.getName()+"写操作完毕");
            } finally {
                rwl.writeLock().unlock();
            }
        }
}
```

#### 注意事项

- 如果有一个线程已经占用了读锁，则此时其他线程如果要申请写锁，则申请写锁的线程会一直等待释放读锁。
- 如果有一个线程已经占用了写锁，则此时其他线程如果申请写锁或者读锁，则申请的线程会一直等待释放写锁。

### Lock和synchronized的选择

1. Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现；
2. synchronized在发生异常时，会自动释放线程占有的锁，因此不会导致死锁现象发生；而Lock在发生异常时，如果没有主动通过unLock()去释放锁，则很可能造成死锁现象，因此使用Lock时需要在finally块中释放锁；
3. Lock可以让等待锁的线程响应中断，而synchronized却不行，使用synchronized时，等待的线程会一直等待下去，不能够响应中断；
4. 通过Lock可以知道有没有成功获取锁，而synchronized却无法办到.
5. Lock可以提高多个线程进行读操作的效率。
6. 在性能上来说，如果竞争资源不激烈，两者的性能是差不多的，而当竞争资源非常激烈时（即有大量线程同时竞争），此时Lock的性能要远远优于synchronized。所以说，在具体使用时要根据适当情况选择。