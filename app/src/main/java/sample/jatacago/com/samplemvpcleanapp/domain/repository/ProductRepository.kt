package sample.jatacago.com.samplemvpcleanapp.domain.repository

import io.reactivex.Single
import sample.jatacago.com.samplemvpcleanapp.domain.entities.Product

interface ProductRepository {
    fun getBySailing(sailingId: String): Single<List<Product>>
}