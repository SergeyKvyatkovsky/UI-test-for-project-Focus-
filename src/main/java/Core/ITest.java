package Core;

//import Helpers.DecodeHelper;
import Helpers.ParamReader;
import Helpers.UserHelper;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ITest {

    public static WebDriver driver = null;

    //Parameters
    public static String url = null;
    public static String username = null;
    public static String password = null;

    //Forms
    public static LoginPage loginPage = null;
    public static DesktopPage desktopPage = null;
    public static HeaderForm headerForm = null;
    public static DataPage dataPage = null;

    public static MainFrame mainFrame = null;

    //Data
    public static Pages.Data.MenuGridPanel dataMenuGridPanel = null;
    public static Pages.Data.Table dataTable = null;
    public static Pages.Data.Toolbar dataToolbar = null;
    public static Pages.Data.DictionaryRecord dataDictionaryRecord = null;

    //Limits
    public static Pages.Limits.LimitsTreeTabPanel limitsTreeTabPanel = null;
    public static Pages.Limits.Table limitsTable = null;
    public static Pages.Limits.Toolbar limitsToolbar = null;
    public static Pages.Limits.CategoryWindow limitsCategoryWindow = null;
    public static Pages.Limits.LimitWindow limitWindow = null;

    //Administration
    public static Pages.Administration.GridPanel administrationGridPanel = null;
    public static Pages.Administration.CommonFilters administrationCommonFilters = null;
    public static Pages.Administration.Timers administrationTimers = null;

    //TradesBlotter
    public static Pages.TradesBlotter.Toolbar tradeToolbar = null;
    public static Pages.TradesBlotter.ParamatersPanel tradeParametersPanel = null;
    public static Pages.TradesBlotter.GridPanel tradeGridPanel = null;
    public static Pages.TradesBlotter.TradeWindow tradeWindow = null;

    public static void initForms()
    {
        loginPage = new LoginPage(driver);
        desktopPage = new DesktopPage(driver);
        headerForm = new HeaderForm(driver);
        dataPage = new DataPage(driver);

        mainFrame = new MainFrame(driver);

        //Data
        dataMenuGridPanel = new Pages.Data.MenuGridPanel(driver);
        dataTable = new Pages.Data.Table(driver);
        dataToolbar = new Pages.Data.Toolbar(driver);
        dataDictionaryRecord = new Pages.Data.DictionaryRecord(driver);

        //Limits
        limitsTreeTabPanel = new Pages.Limits.LimitsTreeTabPanel(driver);
        limitsTable = new Pages.Limits.Table(driver);
        limitsToolbar = new Pages.Limits.Toolbar(driver);
        limitsCategoryWindow = new Pages.Limits.CategoryWindow(driver);
        limitWindow = new Pages.Limits.LimitWindow(driver);

        //Administration
        administrationGridPanel = new Pages.Administration.GridPanel(driver);
        administrationCommonFilters = new Pages.Administration.CommonFilters(driver);
        administrationTimers = new Pages.Administration.Timers(driver);

        //Trades Blotter
        tradeToolbar = new Pages.TradesBlotter.Toolbar(driver);
        tradeParametersPanel = new Pages.TradesBlotter.ParamatersPanel(driver);
        tradeGridPanel = new Pages.TradesBlotter.GridPanel(driver);
        tradeWindow = new Pages.TradesBlotter.TradeWindow(driver);
    }

    @Parameters({"browser", "implicitly_wait"})
    @BeforeClass
    public static void setUpBrowser(String browser, int implicitly_wait) throws Exception
    {
        if (browser.equals("chromeLinux"))
        {
            ChromeDriverService chromeDS = new ChromeDriverService.Builder().usingDriverExecutable(
                    new File(".//files//chromedriver"))
                    .usingAnyFreePort().build();

            chromeDS.start();
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            driver = new ChromeDriver(chromeDS, capability);
        }
        else if (browser.equals("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (browser.equals("chromeWindows"))
        {
            ChromeDriverService chromeDS = new ChromeDriverService.Builder().usingDriverExecutable(
                    new File(".//files//chromedriver.exe"))
                    .usingAnyFreePort().build();

            chromeDS.start();
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            driver = new ChromeDriver(chromeDS, capability);
        }

        driver.manage().timeouts().implicitlyWait(implicitly_wait, TimeUnit.MILLISECONDS);
   //     driver.manage().window().maximize();
        initForms();

        //url = ParamReader.getParameter("url");
        //username = ParamReader.getParameter("username");
        //password = ParamReader.getParameter("password");
        url = ParamReader.getParameterByXpath(ParamReader.general, "//url/text()");
        username = UserHelper.getUsername("s.kviatkovsky");
        password = UserHelper.getPassword("s.kviatkovsky");

    }

    public void navigateTo(String url) throws InterruptedException, IOException {
        driver.get(url);
    }
    
    @AfterClass
    public static void tearDownDriver()
    {
        driver.quit();
    }

}