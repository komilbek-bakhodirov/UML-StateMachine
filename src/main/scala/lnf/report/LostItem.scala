package lnf.report

import lnf.Item
import lnf.Location.{Lichtwiese, Stadtmitte}

class LostItem:
  var item: Option[Item] = None
  var currentState: LostItemState = LostItemState.Init

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

  def transition(): Unit =
    currentState match
      case LostItemState.Init => currentState = LostItemState.Report
      case LostItemState.Report => currentState = LostItemState.ProvideDetail
      case LostItemState.ProvideDetail =>
        if (submit()) currentState = LostItemState.Stored
      case LostItemState.Stored =>
        item.get.location match
            case Stadtmitte =>
              stored()
              currentState = LostItemState.Final
            case Lichtwiese =>
              currentState = LostItemState.Transport
      case LostItemState.Transport =>
        transported()
        currentState = LostItemState.Final
      case LostItemState.Final => // no action is needed
