package sample.jatacago.com.samplemvpcleanapp.domain.usecase

import io.reactivex.Single
import sample.jatacago.com.samplemvpcleanapp.domain.entities.Product

interface GetProductListForSailingUseCase {
    operator fun invoke(sailingId: String): Single<List<Product>>
}
