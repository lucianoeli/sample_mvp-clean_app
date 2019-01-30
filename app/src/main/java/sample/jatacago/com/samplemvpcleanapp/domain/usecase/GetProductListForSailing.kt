package sample.jatacago.com.samplemvpcleanapp.domain.usecase

import sample.jatacago.com.samplemvpcleanapp.domain.repository.ProductRepository

class GetProductListForSailing(private val productRepository: ProductRepository): GetProductListForSailingUseCase {
    override fun invoke(sailingId: String) = productRepository.getBySailing(sailingId)
}
