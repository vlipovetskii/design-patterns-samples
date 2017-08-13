package dzone.shamikmitra;

/*
This seems like a misuse of a nice pattern. How about composition instead? A ball has properties: color, material, ...

I don't understand the IColor/IMaterial example at all. What methods are supposed to be in these interfaces? How would such interface pair enforce some cartesian explosion of implementing classes? How will be IBall instances used in an application having only method createBall?

Does anyone review these articles before they are published? This is so obviously a mis-application of the decorator pattern. It's also awful OO. As Joe has pointed out, color and material are just attributes. There is no combinatorial explosion of classes in this case.
The Gang of Four book is fantastic, one of my favourites, and this does not do it justice. Please, please, please stop printing these articles that are giving such bad advice.
 */
interface IBall {
    public void createBall();
}

class CoreBall implements IBall {
    IBall wrappeBall;

    public CoreBall(IBall wrappeBall) {
        this.wrappeBall = wrappeBall;
    }

    @Override
    public void createBall() {
        System.out.println("Ball creation End");
        if (wrappeBall != null)
            wrappeBall.createBall();
    }
}

class Light implements IBall {
    IBall wrappeBall;

    public Light(IBall wrappeBall) {
        this.wrappeBall = wrappeBall;
    }

    @Override
    public void createBall() {
        System.out.println("Decorate with Disco Light");
        if (wrappeBall != null)
            wrappeBall.createBall();
    }
}

class Smiley implements IBall {
    IBall wrappeBall;

    public Smiley(IBall wrappeBall) {
        this.wrappeBall = wrappeBall;
    }

    @Override
    public void createBall() {
        System.out.println("Decorate with Happy Smiley");
        if (wrappeBall != null)
            wrappeBall.createBall();
    }
}

/**
 * @author Shamik Mitra
 */
public class Main {
    public static void main(String args[]) {
        IBall ball = new Smiley(new Light(new CoreBall(null)));
        ball.createBall();
        System.out.println("*********");
    }
}

