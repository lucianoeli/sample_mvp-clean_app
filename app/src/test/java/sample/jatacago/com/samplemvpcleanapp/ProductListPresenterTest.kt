package sample.jatacago.com.samplemvpcleanapp

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import sample.jatacago.com.samplemvpcleanapp.domain.entities.Product
import sample.jatacago.com.samplemvpcleanapp.domain.usecase.GetProductListForSailing
import sample.jatacago.com.samplemvpcleanapp.domain.usecase.GetProductListForSailingUseCase
import sample.jatacago.com.samplemvpcleanapp.presentation.mvp.presenter.ProductListPresenter
import sample.jatacago.com.samplemvpcleanapp.presentation.mvp.view.productlist.ProductListView

class ProductListPresenterTest {

    private lateinit var presenter: ProductListPresenter

    @Mock lateinit var view: ProductListView
    @Mock lateinit var getProductListForSailing: GetProductListForSailingUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = ProductListPresenter(view, getProductListForSailing)
    }

    @Test
    fun showProductListTest() {
        whenever(getProductListForSailing.invoke(SAILING)).thenReturn(Single.just(PRODUCT_LIST))
        presenter.showProductList(SAILING)
        verify(getProductListForSailing).invoke(SAILING)
        verify(view).showProductList(PRODUCT_LIST)
    }

    @Test
    fun showProductListCrashTest() {
        whenever(getProductListForSailing.invoke(SAILING)).thenReturn(Single.error(NullPointerException("Crash!")))
        presenter.showProductList(SAILING)
        verify(view).showSnagError(ERROR)
    }

    companion object {
        const val SAILING = "AL02102019"
        const val ERROR = "Bad Error!"
        val PRODUCT_LIST = listOf(Product("EU1231J", "Flow Rider,", SAILING))
    }
}