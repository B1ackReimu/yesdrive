package org.example.yesdrive.test.pool;

import java.io.IOException;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;

public class Test {

    public static void main(String[] args) throws InterruptedException, IOException {

        HashSet<Integer> integers = new HashSet<>();
        BitSet bitSet = new BitSet(10);
        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    PooledProcessBuilder pooledProcessBuilder = ProcessBuilderRecycler.get();
                    ProcessBuilder user = pooledProcessBuilder.getProcessBuilder();
                    Process ipconfig;
                    try {
                        user.command("ipconfig");
                        List<String> command = user.command();
                        System.out.println(command);
                        command.add("-all");
                        System.out.println(user.command());
                        ipconfig = user.start();
                        ipconfig.waitFor();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    pooledProcessBuilder.recycle();
                }
            }
        };
        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }*/
        ProcessBuilder processBuilder = new ProcessBuilder("ipconfig");
        Process start = processBuilder.start();
        System.out.println(processBuilder.environment());
        System.out.println(start.getInputStream().read());
        System.out.println(start.isAlive());
        start.waitFor();
    }
}
