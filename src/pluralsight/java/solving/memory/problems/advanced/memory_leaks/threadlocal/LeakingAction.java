package pluralsight.java.solving.memory.problems.advanced.memory_leaks.threadlocal;

import java.util.stream.LongStream;

import static java.util.stream.Collectors.*;

public class LeakingAction implements Runnable {

    private static final String PAD = "AAAA";
    private static final int SIZE = 128 * 1024 / (PAD.length() + 1);

    private static final ThreadLocal<String> threadLocalValue = ThreadLocal.withInitial(() ->
            LongStream.range(0, SIZE)
                    .mapToObj(i -> PAD + i)
                    .collect(joining())
    );

    @Override
    public void run() {
        final String value = threadLocalValue.get();
        System.out.println(value.length());
        // 사용한 ThreadLocal 값을 삭제 하지 않으면 메모리 누수 위험이 있음.
        threadLocalValue.remove();
    }
}