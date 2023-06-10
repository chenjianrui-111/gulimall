package com.atguigu.gulimall.search.thread;

import java.util.concurrent.*;

/**
 * @author CJR
 */
public class ThreadTest02 {

    /**
     * 创建异步对象
     * 1、runXxx 都是没有返回结果的，supplyXxx都是可以获取返回结果的
     * 2、可以传入自定义的线程池，否则就是用默认的线程池
     * 3、根据方法的返回类型来判断是否该方法是否有返回类型
     */
    public static ExecutorService executor = Executors.newFixedThreadPool(10);

//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        System.out.println("main....start.....");
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 2;
//            System.out.println("运行结果：" + i);
//        }, executor);
//
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 2;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executor);
//        Integer integer = future.get();
//
//        System.out.println("main....stop....." + integer);
//    }

    /**
     * 计算完成时回调方法
     * whenComplete 可以处理正常和异常的计算结果，exceptionally 处理异常情况
     * whenComplete 和 whenCompleteAsync 的区别
     * whenComplete ：是执行当前任务的线程继续执行 whenComplete 的任务
     * whenCompleteAsync： 是执行把 whenCompleteAsync 这个任务继续提交给线程池来进行执行
     */

//    public static void main(String[] args) {
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 0;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executor).whenComplete((res,exception) ->{
//            // 虽然能得到异常信息，但是没法修改返回的数据
//            System.out.println("异步任务成功完成了...结果是：" +res + "异常是：" + exception);
//        }).exceptionally(throwable -> {
//            // 可以感知到异常，同时返回默认值
//            return 10;
//        });
//    }

    /**
     * handle 方法
     * 和 complete 一样，可以对结果做最后的处理（可处理异常），可改变返回值
     */
//    public static void main(String[] args) {
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 2;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executor).handle((res,thr) ->{
//            if (res != null ) {
//                return res * 2;
//            }
//            if (thr != null) {
//                return 0;
//            }
//            return 0;
//        });
//    }

    /**
     * 线程串行方法
     * thenApply 方法：当一个线程依赖另一个线程时，获取上一个任务返回的结果，并返回当前任物的返回值
     * thenAccept方法：消费处理结果，接受任务处理结果，并消费处理，无返回结果
     * thenRun 方法：只要上面任务执行完成，就开始执行 thenRun ,只是处理完任务后，执行 thenRun的后续操作
     * 带有 Async 默认是异步执行的，同之前，
     * 以上都要前置任务完成
     */
//    public static void main(String[] args) {
        /**
         * 线程串行化，
         * 1、thenRun:不能获取到上一步的执行结果，无返回值
         * .thenRunAsync(() ->{
         *             System.out.println("任务2启动了....");
         *         },executor);
         * 2、能接受上一步结果，但是无返回值 thenAcceptAsync
         * 3、thenApplyAsync 能收受上一步结果，有返回值
         *
         */
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 2;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executor).thenApplyAsync(res -> {
//            System.out.println("任务2启动了..." + res);
//            return "Hello " + res;
//        }, executor);
//        String s = null;
//        try {
//            s = future.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("main....stop....." + s);
//    }

    /**
     * 两任务组合 - 都要完成
     * 两个任务必须都完成，触发该任务
     * thenCombine: 组合两个 future，获取两个 future的返回结果，并返回当前任务的返回值
     * thenAccpetBoth: 组合两个 future，获取两个 future 任务的返回结果，然后处理任务，没有返回值
     * runAfterBoth:组合 两个 future，不需要获取 future 的结果，只需要两个 future处理完成任务后，处理该任务
     */
//    public static void main(String[] args) {
//        /**
//         * 两个都完成
//         */
//        CompletableFuture<Integer> future01 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("任务1当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 4;
//            System.out.println("任务1结束：" + i);
//            return i;
//        }, executor);
//
//        CompletableFuture<String> future02 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("任务2当前线程：" + Thread.currentThread().getId());
//            System.out.println("任务2结束：");
//            return "Hello";
//        }, executor);
//
//        // f1 和 f2 执行完成后在执行这个
////        future01.runAfterBothAsync(future02,() -> {
////            System.out.println("任务3开始");
////        },executor);
//
//        // 返回f1 和 f2 的运行结果
////        future01.thenAcceptBothAsync(future02,(f1,f2) -> {
////            System.out.println("任务3开始....之前的结果:" + f1 + "==>" + f2);
////        },executor);
//
//        // f1 和 f2 单独定义返回结果
//        CompletableFuture<String> future = future01.thenCombineAsync(future02, (f1, f2) -> {
//            return f1 + ":" + f2 + "-> Haha";
//        }, executor);
//
//        System.out.println("main....end....." + future.get());
//    }

    /**
     * 两任务组合 - 一个完成
     * 当两个任务中，任意一个future 任务完成时，执行任务
     * applyToEither;两个任务有一个执行完成，获取它的返回值，处理任务并有新的返回值
     * acceptEither: 两个任务有一个执行完成，获取它的返回值，处理任务，没有新的返回值
     * runAfterEither:两个任务有一个执行完成，不需要获取 future 的结果，处理任务，也没有返回值
     */
//    public static void main(String[] args) {
        /**
         * 两个任务，只要有一个完成，我们就执行任务
         * runAfterEnitherAsync：不感知结果，自己没有返回值
         * acceptEitherAsync：感知结果，自己没有返回值
         *  applyToEitherAsync：感知结果，自己有返回值
         */
//        future01.runAfterEitherAsync(future02,() ->{
//            System.out.println("任务3开始...之前的结果:");
//        },executor);

//        future01.acceptEitherAsync(future02,(res) -> {
//            System.out.println("任务3开始...之前的结果:" + res);
//        },executor);
//
//        CompletableFuture<Object> future01 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("任务1当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 4;
//            System.out.println("任务1结束：" + i);
//            return i;
//        }, executor);
//
//        CompletableFuture<Object> future02 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("任务2当前线程：" + Thread.currentThread().getId());
//            System.out.println("任务2结束：");
//            return "Hello";
//        }, executor);
//        CompletableFuture<Object> future = future01.applyToEitherAsync(future02, res -> {
//            System.out.println("任务3开始...之前的结果：" + res);
//            return res.toString() + "->哈哈";
//        }, executor);
//    }

    /**
     * 多任务组合
     * allOf：等待所有任务完成
     * anyOf:只要有一个任务完成
     */
//    public static void main(String[] args) {
//        CompletableFuture<String> futureImg = CompletableFuture.supplyAsync(() -> {
//            System.out.println("查询商品的图片信息");
//            return "hello.jpg";
//        });
//
//        CompletableFuture<String> futureAttr = CompletableFuture.supplyAsync(() -> {
//            System.out.println("查询商品的属性");
//            return "黑色+256G";
//        });
//
//        CompletableFuture<String> futureDesc = CompletableFuture.supplyAsync(() -> {
//            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
//            System.out.println("查询商品介绍");
//            return "华为";
//        });
//
//        // 等待全部执行完
////        CompletableFuture<Void> allOf = CompletableFuture.allOf(futureImg, futureAttr, futureDesc);
////        allOf.get();
//
//        // 只需要有一个执行完
//        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(futureImg, futureAttr, futureDesc);
//        try {
//            anyOf.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("main....end....." + anyOf.get());
//    }

}
