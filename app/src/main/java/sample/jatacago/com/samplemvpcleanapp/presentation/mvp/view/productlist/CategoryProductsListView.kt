package sample.jatacago.com.samplemvpcleanapp.presentation.mvp.view.productlist

import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import sample.jatacago.com.samplemvpcleanapp.domain.entities.Product

class CategoryProductsListView(private var activity: AppCompatActivity?) : ProductListView {

    override fun productListSelectionStream(): Observable<Product> {
        //TODO return a valid selection observable
        return Observable.fromCallable { Product("xyz", "", "") }
    }

    override fun showSnagError(message: String) {
        TODO("Implement")
    }

    override fun showProductList(productList: List<Product>) {
        TODO("Implement")
    }

    override fun removeActivityReference() {
        activity = null
    }
}
