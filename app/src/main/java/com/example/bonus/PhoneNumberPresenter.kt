//package com.example.bonus
//
//class PhoneNumberPresenter(private val view: PhoneNumberContract.View) : PhoneNumberContract.Presenter {
//
//    private val formatPhoneNumberInteractor = FormatPhoneNumberInteractor()
//
//    override fun formatPhoneNumber(rawNumber: String) {
//        formatPhoneNumberInteractor.execute(rawNumber, object : FormatPhoneNumberInteractor.Callback {
//            override fun onSuccess(formattedNumber: String) {
//                view.showFormattedNumber(formattedNumber)
//            }
//
//            override fun onError(error: String) {
//                view.showError(error)
//            }
//        })
//    }
//}
