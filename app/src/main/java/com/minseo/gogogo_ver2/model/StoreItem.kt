package com.minseo.gogogo_ver2.model

class StoreItem {
    var id: String = ""
    var name: String = ""
    var address: String = ""
    var degree: Double = 0.0
    var logo: String = ""
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    var distance: Double = 0.0
    var tel: String = ""

    constructor(_id: String, _name: String, _address: String, _degree: Double, _logo: String, _latitude: Double, _longitude: Double, _tel: String) {
        this.id = _id
        this.name = _name
        this.address = _address
        this.degree = _degree
        this.logo = _logo
        this.latitude = _latitude
        this.longitude = _longitude
        this.tel = _tel
    }
}