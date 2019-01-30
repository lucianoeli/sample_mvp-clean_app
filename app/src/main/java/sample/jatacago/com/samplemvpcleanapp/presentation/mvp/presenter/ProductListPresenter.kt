package sample.jatacago.com.samplemvpcleanapp.presentation.mvp.presenter

import io.reactivex.disposables.CompositeDisposable
import sample.jatacago.com.samplemvpcleanapp.domain.usecase.GetProductListForSailingUseCase
import sample.jatacago.com.samplemvpcleanapp.presentation.mvp.presenter.base.Presenter
import sample.jatacago.com.samplemvpcleanapp.presentation.mvp.view.productlist.ProductListView

class ProductListPresenter(
    private val view: ProductListView,
    private val getProductListBySailing: GetProductListForSailingUseCase
) : Presenter {

    private val presenterObservers = CompositeDisposable()

    override fun startObservingView() {
        presenterObservers.add(
            view.productListSelectionStream().subscribe(
                { /* do something */ },
                { /* handle error */ }
            ))
    }

    fun showProductList(sailingId: String) {
        presenterObservers.add(getProductListBySailing(sailingId).subscribe(
            { productList ->
                view.showProductList(productList)
            },
            {
                view.showSnagError("Bad Error!")
            }
        )
        )
    }

    override fun disposeObservers() {
        presenterObservers.clear()
    }
}
