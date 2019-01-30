package sample.jatacago.com.samplemvpcleanapp.presentation.mvp.view.productlist

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.Observable
import sample.jatacago.com.samplemvpcleanapp.domain.entities.Product

interface ProductListView : LifecycleObserver {

    fun productListSelectionStream(): Observable<Product>

    fun showProductList(productList: List<Product>)

    fun showSnagError(message: String)

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun removeActivityReference()
}
