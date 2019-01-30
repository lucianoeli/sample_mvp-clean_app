package sample.jatacago.com.samplemvpcleanapp.presentation.mvp.presenter.base

interface Presenter {
    fun startObservingView()
    fun disposeObservers()
}
