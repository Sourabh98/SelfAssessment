package resources;

import dao.ProductDao;
import entity.Product;
import entity.ProductList;

public class ConnectionTest {

	public static void main(String[] args) {
		
		ProductDao dao=new ProductDao();
		try
		{
		dao.getConnection();
		System.out.println("Connection sucessful..");
		ProductList pList=new ProductService().getAllProducts();
		for(Product product:pList.getProductList())
		{
			System.out.println("Id:    "+product.getId()+"      Brand:     "+product.getBrand()+"	Name:     "+product.getName()+"		Price:   "+product.getPrice());
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
