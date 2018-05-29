package Administration;

import Core.ITest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

import static Helpers.ParamReader.getParameterByXpath;
import static Helpers.ParameterFiles.COMMON_FILTER;
import static Helpers.ParameterFiles.COMMON_FILTER_GROUPS;
import static Helpers.ParameterFiles.limitsCategory;

public class CommonFilter extends ITest{

    @Title("Создание группы общих фильтров")
    @Test(priority = 1)
    public void createGroup() throws IOException, InterruptedException {
        String groupName = getParameterByXpath(COMMON_FILTER_GROUPS, "//group[@name='new']/name/text()");

        navigateTo(url);

        loginPage.authorization(username, password);
        mainFrame.waitForHideLoading();

        headerForm.clickAdminTab();
        administrationCommonFilters.newGroup();
        administrationCommonFilters.typeName(groupName);
        administrationCommonFilters.save();

        mainFrame.waitForSuccessMessage();
    }

    @Title("Создание общего фильтра")
    @Test(priority = 2)
    public void createFilter(){
        String filterName = getParameterByXpath(COMMON_FILTER, "//filter[@name='new']/name/text()");
        String filterBranch = getParameterByXpath(COMMON_FILTER, "//filter[@name='new']/branch/text()");

        administrationCommonFilters.newFilter();
        administrationCommonFilters.typeName(filterName);
        administrationCommonFilters.clickAddCondition();
        administrationCommonFilters.selectField("Branch");

        administrationCommonFilters.clickValue();
        mainFrame.waitForHideLoading();

        administrationCommonFilters.typeDictValueInSearch(filterBranch);
        mainFrame.waitForHideLoading();
        administrationCommonFilters.selectValueFromBranchDict();
        administrationCommonFilters.clickOk();
        administrationCommonFilters.save();
        mainFrame.waitForSuccessMessage();
    }

    @Title("Добавление общего фильтра в категорию лимитов")
    @Test(priority = 3)
    public void addFilterInCategory(){
        headerForm.clickLimitsTab();
        limitsTreeTabPanel.clickCategory();
        limitsToolbar.checkCategoryHeader("ATest Category");

        limitsToolbar.viewCategory();
        mainFrame.waitForHideLoading();
        limitsCategoryWindow.clickEditButton();

        limitWindow.clickAddCommonFilter();
        limitWindow.selectCommonFilter();

        limitsCategoryWindow.clickSaveButton();
        mainFrame.waitForSuccessMessage();
    }

    @Title("Редактирование общего фильтра")
    @Test(priority = 4)
    public void editFilter(){
        String filterBranch = getParameterByXpath(COMMON_FILTER, "//filter[@name='new']/branch/text()");
        String filterName = getParameterByXpath(COMMON_FILTER, "//filter[@name='edit']/name/text()");

        headerForm.clickAdminTab();

        administrationCommonFilters.edit();
        administrationCommonFilters.clickExpression();
        administrationCommonFilters.clickEditOnContextMenu();
        //administrationCommonFilters.selectFieldIssuer();
        administrationCommonFilters.selectField("InstrumentIssuer");
        administrationCommonFilters.selectCondition();

        administrationCommonFilters.clickValue();
        administrationCommonFilters.typeDictValueInSearch(filterBranch);
        mainFrame.waitForHideLoading();
        administrationCommonFilters.selectValueFromBranchDict();
        administrationCommonFilters.clickOk();

        administrationCommonFilters.typeName(filterName);
        administrationCommonFilters.save();
        mainFrame.waitForSuccessMessage();

        //Проверяем фильтр в категории лимитов
        headerForm.clickLimitsTab();
        limitsToolbar.viewCategory();
        mainFrame.waitForHideLoading();

        //Проверка названия
        Assert.assertEquals(filterName, limitsCategoryWindow.getFilterName());

        limitsCategoryWindow.clickEditButton();
        limitsCategoryWindow.viewFilter();

        //Проверки выражения
        Assert.assertEquals("InstrumentIssuer", limitsCategoryWindow.getExpressionElementText(0));
        Assert.assertEquals("≠", limitsCategoryWindow.getExpressionElementText(1).trim());
        Assert.assertEquals("ATB", limitsCategoryWindow.getExpressionElementText(2).trim());

        limitsCategoryWindow.closeViewFilter();
        limitsCategoryWindow.clickCancel();
    }

    @Title("Удаление общего фильтра")
    @Test(priority = 5)
    public void deleteFilter(){
        headerForm.clickAdminTab();
        administrationCommonFilters.delete();
        Assert.assertEquals("Filter is in use.", mainFrame.getTextFromErrorMessage());
        mainFrame.clickErrorMessage();

        headerForm.clickLimitsTab();
        limitsToolbar.viewCategory();
        mainFrame.waitForHideLoading();
        limitsCategoryWindow.clickEditButton();
        limitsCategoryWindow.clearFilter();
        limitsCategoryWindow.clickSaveButton();
        mainFrame.waitForSuccessMessage();
        headerForm.clickAdminTab();
        administrationCommonFilters.selectFilterGroup();
        //Проверка недоступности кнопки Удалить
        Assert.assertTrue(administrationCommonFilters.isDeleteButtonDisabled());

        administrationCommonFilters.selectFilter();
        administrationCommonFilters.delete();
        mainFrame.waitForSuccessMessage();
        administrationCommonFilters.selectFilterGroup();
        administrationCommonFilters.delete();
        mainFrame.waitForSuccessMessage();

    }

}
