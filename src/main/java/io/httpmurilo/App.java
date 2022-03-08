package io.httpmurilo;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        try {
            ConnectComponent comp = new ConnectComponent();
            System.out.println(comp.tryConnection());

            ProductsComponent productsComponent = new ProductsComponent();
            System.out.println(productsComponent.tryConnection());
            System.out.println(productsComponent.tryConnectionForClassName());
            productsComponent.printProductList();
            productsComponent.printProductListTwo();
            productsComponent.printProductListThree();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
