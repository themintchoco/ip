public class EchoCommand extends Command {
    private String echo;

    public EchoCommand(String echo) {
        this.echo = echo;
    }

    @Override
    public String handle() {
        return echo;
    }
}
