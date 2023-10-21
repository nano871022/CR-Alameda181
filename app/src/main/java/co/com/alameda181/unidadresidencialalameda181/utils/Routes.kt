package co.com.alameda181.unidadresidencialalameda181.utils

import co.com.alameda181.unidadresidencialalameda181.R

enum class DrawerRoutes constructor(val title:Int,val icon:Int){
  HOME(R.string.menu_home,R.drawable.baseline_home_24)
  ,LOCATION(R.string.menu_location,R.drawable.baseline_gps_fixed_24)
  ,GENERAL_INFORMATION(R.string.menu_general_inforamtion,R.drawable.baseline_general_24)
  ,PAYMENT_INFORMATION(R.string.menu_payment_information,R.drawable.baseline_monetization_on_24)
  ,MOVEMENT_INFORMATION(R.string.menu_movement_information,R.drawable.baseline_moving_24)
  ,RENTAL_INFORMATION(R.string.menu_renting_information,R.drawable.baseline_renting_24)
  ,LOCAL_REPAIRS(R.string.menu_local_repairs,R.drawable.baseline_repair_24)
  ,REGULATION(R.string.menu_regulation,R.drawable.baseline_rule_24)
}

enum class MenuOptions constructor(val title:Int,val icon:Int){
  ABOUT(R.string.menu_about,R.drawable.baseline_info_24)

}

enum class TopMenuOption constructor(val title:Int,val icon:Int){
  SCHEDULES(R.string.schedules,R.drawable.baseline_calendar_month_24)
  , ADMINISTRATION_PAYMENT(R.string.payment_administration,R.drawable.baseline_attach_money_24)
}

enum class MAIN_MENU{
  SPLASH,
  MAIN
}