import service.Hospital;
class TokenMonitor extends Thread {

    private Hospital hospital;

    public TokenMonitor(Hospital hospital) {
        this.hospital = hospital;
    }

    @Override
    public void run() {

        System.out.println("Token monitoring started.");

        for (int i = 1; i <= 5; i++) {

            System.out.println(
                "Background monitoring cycle: " + i
            );

            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                System.out.println("Monitoring interrupted.");
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("Token monitoring completed.");
    }
}
