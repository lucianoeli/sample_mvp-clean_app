package sample.jatacago.com.samplemvpcleanapp.data.repository

import io.reactivex.Single
import sample.jatacago.com.samplemvpcleanapp.domain.entities.Product
import sample.jatacago.com.samplemvpcleanapp.domain.repository.ProductRepository as IProductRepository

class ProductRepository : IProductRepository {
    override fun getBySailing(sailingId: String): Single<List<Product>> =
        Single.just(listOf(Product("ASE28328", "Flow Rider", "AL02122019")))
}