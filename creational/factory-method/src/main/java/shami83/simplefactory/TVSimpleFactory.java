package shami83.simplefactory;

/**
 * @author Shamik Mitra
 *
 */
interface ITV {
    public void createTV();
}

/**
 * @author Shamik Mitra
 *
 */
public class TVSimpleFactory {
    enum TVMODE{COLOR,LED,LCD,THREEDIM};
    public static ITV getTV(TVMODE mode){
        if(mode.equals(TVMODE.LED)){
            return new ITV(){
                @Override
                public void createTV() {
                    System.out.println("LED TV");
                }
            };
        }
        return null;
    }
    public static void main(String[] args) {
        TVSimpleFactory.getTV(TVMODE.LED).createTV();
    }
}

