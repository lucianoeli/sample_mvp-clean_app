package sample.jatacago.com.samplemvpcleanapp.framework

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import sample.jatacago.com.samplemvpcleanapp.R
import sample.jatacago.com.samplemvpcleanapp.data.repository.ProductRepository
import sample.jatacago.com.samplemvpcleanapp.domain.usecase.GetProductListForSailing
import sample.jatacago.com.samplemvpcleanapp.presentation.mvp.presenter.ProductListPresenter
import sample.jatacago.com.samplemvpcleanapp.presentation.mvp.presenter.base.Presenter
import sample.jatacago.com.samplemvpcleanapp.presentation.mvp.view.productlist.ProductListView
import sample.jatacago.com.samplemvpcleanapp.presentation.mvp.view.productlist.CategoryProductsListView

class ProductListActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var presenter: Presenter
    private lateinit var lifeCycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productListView = CategoryProductsListView(this)
        initLifeCycle(productListView)
        presenter = ProductListPresenter(
            productListView,
            GetProductListForSailing(ProductRepository())
        )
    }

    private fun initLifeCycle(productListView: ProductListView) {
        lifeCycleRegistry = LifecycleRegistry(this)
        lifeCycleRegistry.addObserver(productListView)
        lifeCycleRegistry.markState(Lifecycle.State.STARTED)
    }

    override fun onResume() {
        super.onResume()
        presenter.startObservingView()
    }

    override fun onPause() {
        super.onPause()
        presenter.disposeObservers()
    }

    override fun onDestroy() {
        lifeCycleRegistry.markState(Lifecycle.State.DESTROYED)
        super.onDestroy()
    }
}
