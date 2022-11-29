public class SiteMap {
    private String loc;
    private String lastMod;
    private float priority;

    public SiteMap(String loc, String lastMod, float priority) {
        this.loc = loc;
        this.lastMod = lastMod;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "SiteMap{" +
                "loc='" + loc + '\'' +
                ", lastMod='" + lastMod + '\'' +
                ", priority=" + priority +
                '}';
    }
}
