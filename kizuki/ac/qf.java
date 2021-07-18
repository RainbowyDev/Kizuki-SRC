package kizuki.ac;

public enum qf
{
    II("Never", 0, "N"), 
    iI("TenMinutes", 1, "10M"), 
    Ii("OneHour", 2, "1H"), 
    ii("OneDay", 3, "1D"), 
    ll("OneWeek", 4, "1W"), 
    lI("TwoWeek", 5, "2W"), 
    Il("OneMonth", 6, "1M");
    
    private final String II;
    
    private qf(final String s, final int n, final String ii) {
        this.II = ii;
    }
    
    public static qf II(final String s) {
        switch (s) {
            case "N": {
                return qf.II;
            }
            case "10M": {
                return qf.iI;
            }
            case "1H": {
                return qf.Ii;
            }
            case "1D": {
                return qf.ii;
            }
            case "1W": {
                return qf.ll;
            }
            case "2W": {
                return qf.lI;
            }
            case "1M": {
                return qf.Il;
            }
            default: {
                throw new UnsupportedOperationException("PasteExpire " + s + " is not supported yet");
            }
        }
    }
    
    public String II() {
        return this.II;
    }
}
