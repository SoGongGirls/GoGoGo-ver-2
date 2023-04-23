package com.minseo.gogogo_ver2.view.storeInfo

class StoreItem(
    val storeName: String,
    val storeGrade: String,
    val storeId: Int,
    val storeLogo: String,
    private val storeLatitude: Double,
    private val storeLongitude: Double
) {
    // return DistanceByDegree(my_location.myLatitude, my_location.myLongitude, storeLatitude, storeLongitude);
//    val storeDistance: Double
//        get() =// return DistanceByDegree(my_location.myLatitude, my_location.myLongitude, storeLatitude, storeLongitude);
//            DistanceByDegree(
//                Roulette.myLatitude,
//                Roulette.myLongitude,
//                storeLatitude,
//                storeLongitude
//            )

    // 원하는 위치에서 위치까지 거리를 계산해주는 함수
    fun DistanceByDegree(lat1: Double, lng1: Double, lat2: Double, lng2: Double): Double {
        val theta: Double
        var dist: Double
        theta = lng1 - lng2
        dist = Math.sin(DegreeToRadian(lat1)) * Math.sin(DegreeToRadian(lat2)) + (Math.cos(
            DegreeToRadian(lat1)
        )
                * Math.cos(DegreeToRadian(lat2)) * Math.cos(DegreeToRadian(theta)))
        dist = Math.acos(dist)
        dist = RadianToDegree(dist)
        dist = dist * 60 * 1.1515
        dist = dist * 1.609344 // 단위 mile 에서 km 변환
        return dist
    }

    //degree->radian 변환
    fun DegreeToRadian(degree: Double): Double {
        return degree * Math.PI / 180.0
    }

    //randian -> degree 변환
    fun RadianToDegree(radian: Double): Double {
        return radian * 180.0 / Math.PI
    }
}