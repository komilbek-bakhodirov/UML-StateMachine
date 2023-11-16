package lnf.report

import lnf.Item

class LostItem:
  var item: Option[Item] = None

  private def submit(): Boolean = item.isDefined

  private def stored(): Unit =
    println(raw".________________________.")
    println(raw"||__===____________===__||")
    println(raw"||                      ||")
    println(raw"|:----------------------:|")
    println(raw"|| ${item.get.box(18)} ||")
    println(raw"||______________________||")
    println(raw"''----------------------''")
  
  private def transported(): Unit =
    println(raw"        _______")
    println(raw"       //  ||\ \ ")
    println(raw" _____//___||_\ \___")
    println(raw" )  _ ${item.get.box(6)} _    \ ")
    println(raw" |_/ \________/ \___|")
    println(raw"___\_/________\_/______")

  def transition(): Unit = ???
