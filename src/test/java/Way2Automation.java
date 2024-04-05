import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

public class Way2Automation {

    public static boolean assertEquals(String actual, String expected) {
        return actual.equals(expected);
    }
    
    @Test//Droppable - default functionality
    public void TS1Way2AutoTC1() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        WebElement draggableElement = driver.findElement(By.xpath("/html/body/div[1]"));
        WebElement droppableElement = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableElement, droppableElement).build().perform();
    }

    @Test//Droppable - accept
    public void TS1Way2AutoTC2() {
        String drop = "Dropped!";
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));
        WebElement draggableElement = driver.findElement(By.id("draggable"));
        WebElement droppableElement = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableElement, droppableElement).build().perform();

        WebElement dropText = driver.findElement(By.xpath("/html/body/div[3]/p"));
        Assert.assertEquals(dropText.getText(),drop);

    }

    @Test//Droppable - prevent propagation
    public void TS1Way2AutoTC3() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[3]")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[3]/div/iframe")));
        WebElement draggableElement = driver.findElement(By.xpath("/html/body/div[1]"));
        WebElement droppableElement = driver.findElement(By.xpath("/html/body/div[2]/div"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableElement, droppableElement).build().perform();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement droppable2Element = driver.findElement(By.xpath("/html/body/div[3]/div"));
        Actions actions2 = new Actions(driver);
        actions.dragAndDrop(draggableElement, droppable2Element).build().perform();
    }

    @Test//Droppable - revert draggable position
    public void TS1Way2AutoTC4() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[4]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[4]/div/iframe")));
        WebElement draggableElement = driver.findElement(By.xpath("/html/body/div[1]"));
        WebElement droppableElement = driver.findElement(By.xpath("/html/body/div[3]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableElement, droppableElement).build().perform();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement draggable2Element = driver.findElement(By.xpath("/html/body/div[2]"));
        Actions actions2 = new Actions(driver);
        actions2.dragAndDrop(draggable2Element, droppableElement).build().perform();
    }

    @Test//Resizable - default functionality
    public void TS2Way2AutoTC1() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[3]/a/figure")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        WebElement resizableElement = driver.findElement(By.xpath("/html/body/div/div[3]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizableElement).moveByOffset(150, 50).release().build().perform();
    }

    @Test//Resizable - animate
    public void TS2Way2AutoTC2() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[3]/a/figure")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));
        WebElement resizableElement = driver.findElement(By.xpath("/html/body/div/div[3]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizableElement).moveByOffset(250, 150).release().build().perform();
    }

    @Test//Resizable - constrain resize area
    public void TS2Way2AutoTC3() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[3]/a/figure")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[3]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[3]/div/iframe")));
        WebElement resizableElement = driver.findElement(By.xpath("/html/body/div/div/div[3]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizableElement).moveByOffset(50, 50).release().build().perform();
    }

    @Test//Resizable - helper
    public void TS2Way2AutoTC4() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[3]/a/figure")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[4]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[4]/div/iframe")));
        WebElement resizableElement = driver.findElement(By.xpath("/html/body/div/div[3]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizableElement).moveByOffset(300, 150).release().build().perform();
    }

    @Test//Resizable - max/min size
    public void TS2Way2AutoTC5() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[3]/a/figure")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[5]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[5]/div/iframe")));
        WebElement resizableElement = driver.findElement(By.xpath("/html/body/div/div[3]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizableElement).moveByOffset(150, 20).release().build().perform();
    }

    @Test//Accordion - default functionality
    public void TS3Way2AutoTC1() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[2]/ul/li[1]/a/h2")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        String text1 = "Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.";
        WebElement sectionText = driver.findElement(By.xpath("/html/body/div/div[1]/p"));
        Assert.assertEquals(sectionText.getText(), text1);

        driver.findElement(By.xpath("/html/body/div/h3[2]")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text2 = "Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.";
        WebElement section2Text = driver.findElement(By.xpath("/html/body/div/div[2]/p"));
        Assert.assertEquals(section2Text.getText(), text2);

        driver.findElement(By.xpath("/html/body/div/h3[3]")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text3 = "Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.\n" +
                "List item one\n" +
                "List item two\n" +
                "List item three";
        WebElement section3Text = driver.findElement(By.xpath("/html/body/div/div[3]"));
        Assert.assertEquals(section3Text.getText(), text3);

        driver.findElement(By.xpath("/html/body/div/h3[4]")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text4 = "Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est.";
        WebElement section4Text = driver.findElement(By.xpath("/html/body/div/div[4]/p[1]"));
        Assert.assertEquals(section4Text.getText(), text4);
        String text5 = "Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.";
        WebElement section5Text = driver.findElement(By.xpath("/html/body/div/div[4]/p[2]"));
        Assert.assertEquals(section5Text.getText(), text5);
    }

    @Test//Accordion - customize icons
    public void TS3Way2AutoTC2() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[2]/ul/li[1]/a/h2")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));

        String text1 = "Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.";
        WebElement sectionText = driver.findElement(By.xpath("/html/body/div/div[1]/p"));
        Assert.assertEquals(sectionText.getText(), text1);

        driver.findElement(By.xpath("/html/body/div/h3[2]")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text2 = "Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.";
        WebElement section2Text = driver.findElement(By.xpath("/html/body/div/div[2]/p"));
        Assert.assertEquals(section2Text.getText(), text2);

        driver.findElement(By.xpath("/html/body/div/h3[3]")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text3 = "Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.\n" +
                "List item one\n" +
                "List item two\n" +
                "List item three";
        WebElement section3Text = driver.findElement(By.xpath("/html/body/div/div[3]"));
        Assert.assertEquals(section3Text.getText(), text3);

        driver.findElement(By.xpath("/html/body/div/h3[4]")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text4 = "Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est.";
        WebElement section4Text = driver.findElement(By.xpath("/html/body/div/div[4]/p[1]"));
        Assert.assertEquals(section4Text.getText(), text4);
        String text5 = "Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.";
        WebElement section5Text = driver.findElement(By.xpath("/html/body/div/div[4]/p[2]"));
        Assert.assertEquals(section5Text.getText(), text5);

        driver.findElement(By.xpath("/html/body/button")).click();
    }

    @Test//Accordion - fill space
    public void TS3Way2AutoTC3() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[2]/ul/li[1]/a/h2")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[3]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[3]/div/iframe")));
        WebElement containerElement = driver.findElement(By.xpath("/html/body/div/div[4]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(containerElement).moveByOffset(500, 150).release().build().perform();

        String text1 = "Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.";
        WebElement sectionText = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/p"));
        Assert.assertEquals(sectionText.getText(), text1);

        driver.findElement(By.xpath("/html/body/div/div[1]/h3[2]")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text2 = "Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.";
        WebElement section2Text = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/p"));
        Assert.assertEquals(section2Text.getText(), text2);

        driver.findElement(By.xpath("/html/body/div/div[1]/h3[3]")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text3 = "Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.";
        WebElement section3Text = driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/p"));
        Assert.assertEquals(section3Text.getText(), text3);

        driver.findElement(By.xpath("/html/body/div/div[1]/h3[4]")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text4 = "Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est.";
        WebElement section4Text = driver.findElement(By.xpath("/html/body/div/div[1]/div[4]/p[1]"));
        Assert.assertEquals(section4Text.getText(), text4);
        String text5 = "Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.";
        WebElement section5Text = driver.findElement(By.xpath("/html/body/div/div[1]/div[4]/p[2]"));
        Assert.assertEquals(section5Text.getText(), text5);
    }

    @Test//Autocomplete - default functionality
    public void TS4Way2AutoTC1() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[2]/ul/li[2]/a/figure")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        driver.findElement(By.id("tags")).sendKeys("java");
        driver.findElement(By.id("tags")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    @Test//Autocomplete - multiple values
    public void TS4Way2AutoTC2() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[2]/ul/li[2]/a/figure")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));
        driver.findElement(By.id("tags")).sendKeys("pyth");
        driver.findElement(By.id("tags")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(By.id("tags")).sendKeys("javasc");
        driver.findElement(By.id("tags")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(By.id("tags")).sendKeys("c+");
        driver.findElement(By.id("tags")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    @Test//Autocomplete - categories
    public void TS4Way2AutoTC3() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[2]/ul/li[2]/a/figure")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[3]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[3]/div/iframe")));
        driver.findElement(By.id("search")).sendKeys("an");
        driver.findElement(By.id("search")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("search")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
    }

    @Test//Datepicker - default functionality
    public void TS5Way2AutoTC1() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[2]/ul/li[3]/a/figure")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath("/html/body/div/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[4]/a")).click();
    }

    @Test//Datepicker - default functionality
    public void TS5Way2AutoTC2() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[2]/ul/li[3]/a/figure")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));
        driver.findElement(By.xpath("/html/body/p[2]/select")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/p[2]/select")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(By.id("datepicker")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[5]/a")).click();
    }

    @Test//Datepicker - display month and year
    public void TS5Way2AutoTC3() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[2]/ul/li[3]/a/figure")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[3]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[3]/div/iframe")));
        driver.findElement(By.id("datepicker")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div/div/div/select[1]")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div/div/div/select[1]")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(By.xpath("/html/body/div/div/div/select[2]")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div/div/div/select[2]")).sendKeys(Keys.ARROW_UP, Keys.ARROW_UP, Keys.ENTER);
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr[4]/td[6]/a")).click();
    }

    @Test//Datepicker - format date
    public void TS5Way2AutoTC4() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[2]/ul/li[3]/a/figure")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[4]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[4]/div/iframe")));
        driver.findElement(By.xpath("/html/body/p[2]/select")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/p[2]/select")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(By.id("datepicker")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr[5]/td[3]/a")).click();
    }

    @Test//Tabs
    public void TS6Way2AutoTC1() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[2]/ul/li[6]/a/figure")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div/div/iframe")));

        String text1 = "Proin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.";
        driver.findElement(By.xpath("/html/body/div/ul/li[1]/a")).click();
        WebElement tab1Text = driver.findElement(By.xpath("/html/body/div/div[1]/p"));
        Assert.assertEquals(tab1Text.getText(), text1);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String text2 = "Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris consectetur tortor et purus.";
        driver.findElement(By.xpath("/html/body/div/ul/li[2]/a")).click();
        WebElement tab2Text = driver.findElement(By.xpath("/html/body/div/div[2]/p"));
        Assert.assertEquals(tab2Text.getText(), text2);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String text3 = "Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus.";
        driver.findElement(By.xpath("/html/body/div/ul/li[3]/a")).click();
        WebElement tab3Text = driver.findElement(By.xpath("/html/body/div/div[3]/p[1]"));
        Assert.assertEquals(tab3Text.getText(), text3);
    }

    @Test//Tooltip - custom animation demo
    public void TS7Way2AutoTC1() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[2]/ul/li[7]/a/figure")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));
        WebElement resizableElement = driver.findElement(By.xpath("/html/body/p[2]/a[1]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizableElement).moveByOffset(300, 50).build().perform();
    }

    @Test//Frames and Windows - open new window
    public void TS8Way2AutoTC1() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[3]/ul/li/a/figure")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        driver.findElement(By.xpath("/html/body/div/p/a")).click();
    }

    @Test//Frames and Windows - open separate window
    public void TS8Way2AutoTC2() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[3]/ul/li/a/figure")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));
        driver.findElement(By.xpath("/html/body/div/p/a")).click();
    }

    @Test//Frames and Windows - frameset
    public void TS8Way2AutoTC3() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[3]/ul/li/a/figure")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[3]")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[3]/div/iframe")));
        driver.findElement(By.xpath("/html/body/div/p/a")).click();
    }

    @Test//Frames and Windows - open multiple windows
    public void TS8Way2AutoTC4() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[3]/ul/li/a/figure")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[4]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[4]/div/iframe")));
        driver.findElement(By.xpath("/html/body/div/p/a")).click();
    }

    @Test//Dropdown - select country
    public void T9Way2AutoTC1() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[4]/ul/li[2]/a/figure")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        driver.findElement(By.xpath("/html/body/select")).click();

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[4]/ul/li[2]/a/figure")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        driver.findElement(By.xpath("/html/body/select")).click();
        driver.findElement(By.xpath("/html/body/select")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement el = driver.findElement(By.xpath("/html/body/select/option[126]"));
//        el.click();
//        Actions action = new Actions(driver);
//        action.moveToElement(el).perform();
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.quit();

        // Select row based on a string present
//        driver.findElement(By.xpath("/html/body/select[contains(text(), 'Lithuania')]")).click();
//
//        driver.quit();

//        JavascriptExecutor je = (JavascriptExecutor) driver;
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        je.executeScript("dropdown.scrollBy(0,3000)");
//        WebElement element = driver.findElement(By.linkText("Lithuania"));
//        je.executeScript("arguments[0].scrollIntoView();", element);
    }

    @Test//Dropdown - select country
    public void T9Way2AutoTC2() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[4]/ul/li[2]/a/figure")).click();
        driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));
        driver.findElement(By.id("combobox")).click();
        driver.findElement(By.id("combobox")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
    }

//    @Test//Registration
//    public void T10Way2AutoTC1() {
//        ChromeDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[5]/ul/li/a/figure")).click();
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));
//        driver.findElement(By.id("combobox")).click();
//        driver.findElement(By.id("combobox")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//    }


//    driver.switchTo().defaultContent();

//      try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
//        cartButton.click();
//        WebElement cartText = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span"));
//        Assert.assertEquals(cartText.getText(),cart);

    //WebElement resultText = driver.findElement(By.id("datepicker"));
    //String fieldValue = resultText.getAttribute("value");

//    options.addArguments("--disable-notifications");//prie setup

    //https://ultimateqa.com/complicated-page
    //Su login forms: Iš valdincinės užduoties, kuri mūsų prašo sudėti du skaičius -
    // nuskaityti tuos skaičius kaip kintamuosius, atlikti matematinį veiksmą ir gautą rezultatą įvesti
    // prieš pateikiant užpildyta formą. 3 test case - kai suma teisinga, kai suma neteisinga ir kai sumos neivedame

}
