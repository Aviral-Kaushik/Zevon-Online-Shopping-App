package com.aviral.zevon.Models

data class SellerUser(
    var sellerId: String,
    var email: String?,
    var name: String?,
    var comapny: String?,
    var country: String?,
    var number: String?,
    var pan: String?,
    var gstin: String?,
    var aadhar: String?,
    var aadharLocation: String?,
    var panLocation: String?,
    var gstinLocation: String?
)