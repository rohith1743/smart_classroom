
interface Image {
    String describe();
    void show();
}


class SimpleImage implements Image {
    private String name;

    public SimpleImage(String name) {
        this.name = name;
    }

    public String describe() {
        return "Image: " + name;
    }

    public void show() {
        System.out.println(describe());
    }
}


abstract class ImageDecorator implements Image {
    protected Image image;

    public ImageDecorator(Image image) {
        this.image = image;
    }

    public String describe() {
        return image.describe();
    }

    public void show() {
        image.show();
    }
}


class BnwFilter extends ImageDecorator {
    public BnwFilter(Image image) {
        super(image);
    }

    public String describe() {
        return image.describe() + " with Black and White effect";
    }

    public void show() {
        super.show();
        System.out.println("Applying Black and White effect...");
    }
}


class SepiaEffect extends ImageDecorator {
    public SepiaEffect(Image image) {
        super(image);
    }

    public String describe() {
        return image.describe() + " with Sepia effect";
    }

    public void show() {
        super.show();
        System.out.println("Applying Sepia effect...");
    }
}


class Main {
    public static void main(String[] args) {
        Image vacationPhoto = new SimpleImage("Vacation.jpg");
        vacationPhoto.show();

        vacationPhoto = new BnwFilter(vacationPhoto);
        vacationPhoto.show();

        vacationPhoto = new SepiaEffect(vacationPhoto);
        vacationPhoto.show();
    }
}
