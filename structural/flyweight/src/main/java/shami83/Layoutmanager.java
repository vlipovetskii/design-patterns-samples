package shami83;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shamik Mitra
 *
 */
interface IWidget {
    public void setWidgetName(String name);
    public String getWidgetName();
    public void setWidgetContent(String content);
    public void display();
    public void applyTheme(String color,String postion,Layoutmanager manager);
}

/**
 * @author Shamik Mitra
 *
 */
public class Layoutmanager {
    private static Layoutmanager mgr = new Layoutmanager();
    Map<String,IWidget> map = new HashMap<String,IWidget>();
    public static Layoutmanager get(){
        return mgr;
    }
    private Layoutmanager(){
        init();
    }
    public void addWidget(IWidget widget,String position){
        System.out.println("Adding Widget " + widget.getWidgetName()+  " in to position " + position);
    }
    private void init(){
        IWidget followerWidget = new IWidget(){
            private String name;
            private String content;
            private String color;
            private String position;
            @Override
            public void setWidgetName(String name) {
                this.name=name;
            }
            @Override
            public String getWidgetName() {
                return name;
            }
            @Override
            public void setWidgetContent(String content) {
                System.out.println("setting content first-time....loading from back end costly operation");
                this.content=content;
            }
            @Override
            public void display() {
                System.out.println(" Widget name : " + name);
                System.out.println(" Widget color : " + color);
                System.out.println(" Widget color : " + position);
                System.out.println(" Widget content : " + content);
            }
            @Override
            public void applyTheme(String color, String postion, Layoutmanager manager) {
                this.color=color;
                this.position=postion;
                manager.addWidget(this,postion);
            }
        };
        followerWidget.setWidgetName("Follower Widget");
        followerWidget.setWidgetContent("Showing blog Followers.");
        followerWidget.applyTheme("Blue", "LEFT", this);
        followerWidget.display();
        map.put(followerWidget.getWidgetName(), followerWidget);
    }
    public void changeTheme(){
        System.out.println("After Change Theme");
        for(String name : map.keySet()){
            if("Follower Widget".equalsIgnoreCase(name)){
                IWidget widget = map.get(name);
                widget.applyTheme("Green", "RIGHT", this);
                widget.display();
            }
        }
    }
    public static void main(String[] args) {
        Layoutmanager mgr = Layoutmanager.get();
        mgr.changeTheme();
    }
}
