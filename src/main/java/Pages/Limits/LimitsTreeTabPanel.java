package Pages.Limits;

import Core.IPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LimitsTreeTabPanel extends IPage{

    //Все категории
    By divAllCategories = By.xpath("//td[@id='rootCategory']/div");

    //? ATest Category
    By divTestCategory = By.xpath("//div[starts-with(@id, 'categoriesTree')]//div[text()='ATest Category']");

    //ATest Subcategory
    By divTestSubcategory = By.xpath("//div[starts-with(@id, 'categoriesTree')]//div[text()='ATest Subcategory']");

    public LimitsTreeTabPanel(WebDriver driver) {
        super(driver);
    }

    public LimitsTreeTabPanel clickAllCategories(){
        waitFor(divAllCategories);
        click(divAllCategories);
        return this;
    }

    public LimitsTreeTabPanel clickCategory(){
        waitFor(divTestCategory);
        click(divTestCategory);
        return this;
    }

    public LimitsTreeTabPanel doubleClickCatagory(){
        waitFor(divTestCategory);
        doubleClick(divTestCategory);
        return this;
    }

    public LimitsTreeTabPanel clickSubcategory(){
        waitFor(divTestSubcategory);
        click(divTestSubcategory);
        return this;
    }

}
