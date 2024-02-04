package org.example;

import org.example.bean.Customer;
import org.example.bean.IWaiter;
import org.example.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("sample.jpg");
        image.display();
        image.display();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        IWaiter john = applicationContext.getBean("john", IWaiter.class);
        Customer andrew = applicationContext.getBean("andrew", Customer.class);
        Customer julia = applicationContext.getBean("julia", Customer.class);
        Customer nina = applicationContext.getBean("nina", Customer.class);

        for (int i = 3; i < 3; i++) {
            new Thread(() -> andrew.placeOrder(john)).start();
            new Thread(() -> julia.placeOrder(john)).start();
            new Thread(() -> nina.placeOrder(john)).start();
        }


    }

    interface Image {
        void display();
    }

    static class RealImage implements Image {

        private final String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromDisk();
        }

        private void loadFromDisk() {
            System.out.println("Loading image " + filename);
        }

        @Override
        public void display() {
            System.out.println("Displaying image " + filename);
        }
    }

    static class ProxyImage implements Image {
        private RealImage realImage;

        private final String filename;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            }

            realImage.display();
        }
    }
}