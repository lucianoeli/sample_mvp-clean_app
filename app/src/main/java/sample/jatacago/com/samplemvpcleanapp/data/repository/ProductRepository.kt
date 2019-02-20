package sample.jatacago.com.samplemvpcleanapp.data.repository

import io.reactivex.Single //observable que emite 1 solo valor o error
import sample.jatacago.com.samplemvpcleanapp.domain.entities.Product
import sample.jatacago.com.samplemvpcleanapp.domain.repository.ProductRepository as IProductRepository

class ProductRepository : IProductRepository {

    // implementa repositorio, y brinda el metodo para recuperar los datos de una DB o Service Call
    override fun getBySailing(sailingId: String): Single<List<Product>> =
        Single.just(listOf(Product("ASE28328", "Flow Rider", "AL02122019")))
}