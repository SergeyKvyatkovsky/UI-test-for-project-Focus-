package Limits;

import Core.ITest;
import Helpers.ParamReader;
import Helpers.ParameterFiles;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

public class Categories extends ITest{


    @Title("Создание категории")
    @Test(priority = 1)
    public void createCategory() throws IOException, InterruptedException {

        final String categoryName = ParamReader.getParameterByXpath(ParameterFiles.limitsCategory, "//category[@name='new']/name/text()");

        navigateTo(url);
        //Авторизация
        loginPage.authorization(username, password);
        mainFrame.waitForHideLoading();

        //Нажатие на вкладку Лимиты
        headerForm.clickLimitsTab();
        //Нажатие на "Все категории"
        limitsTreeTabPanel.clickAllCategories();
        mainFrame.waitForHideLoading();

        //Нажатие 'Создать подкатегорию'
        limitsToolbar.createSubcategory();
        mainFrame.waitForHideLoading();

        //Ввод наименования категории
        limitsCategoryWindow.waitForHeaderText();
        limitsCategoryWindow.typeCategoryName(categoryName);

        //Нажатие на кнопку Сохранить
        limitsCategoryWindow.clickSaveButton();

        //Ожидание сообщения об успехе
        mainFrame.waitForSuccessMessage();
        //Проверка названия
        limitsToolbar.checkCategoryHeader(categoryName);
    }

    @Title("Изменить категорию")
    @Test(priority = 2)
    public void editCategory(){

        final String categoryName = ParamReader.getParameterByXpath(ParameterFiles.limitsCategory, "//category[@name='edit']/name/text()");

        limitsToolbar.viewCategory();
        mainFrame.waitForHideLoading();

        limitsCategoryWindow.clickEditButton();
        limitsCategoryWindow.typeCategoryName(categoryName);

        //Нажатие на "Добавить произвольный"
        limitsCategoryWindow.clickAddCustomFilterButton();

        //Добавить условие
        limitsCategoryWindow.clickExprAddCond();

        limitsCategoryWindow.selectAgreementType();

        limitsCategoryWindow.clickValueInput();
        mainFrame.waitForHideLoading();

        limitsCategoryWindow.selectAlfaDirect();

        limitsCategoryWindow.clickOkInConditions();
        limitsCategoryWindow.clickOkInFilter();

        limitsCategoryWindow.clickSaveButton();

        mainFrame.waitForSuccessMessage();
    }

    @Title("Удаление категории")
    @Test(priority = 3)
    public void deleteCategory(){
        limitsToolbar.viewCategory();
        mainFrame.waitForHideLoading();

        limitsCategoryWindow.deleteCategory();
        mainFrame.waitForSuccessMessage();
    }

}
