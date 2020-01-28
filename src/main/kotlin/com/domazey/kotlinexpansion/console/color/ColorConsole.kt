package com.domazey.kotlinexpansion.console.color

import com.domazey.kotlinexpansion.console.color.ConsoleColor.Background
import com.domazey.kotlinexpansion.console.color.ConsoleColor.Foreground
import com.domazey.kotlinexpansion.console.color.ConsoleColor.Reset

sealed class ConsoleColor(val ansiSequence: String) {

  sealed class Foreground(ansiSequence: String) : ConsoleColor(ansiSequence) {
    object BLACK : Foreground("\u001B[30m")
    object RED : Foreground("\u001B[31m")
    object GREEN : Foreground("\u001B[32m")
    object YELLOW : Foreground("\u001B[33m")
    object BLUE : Foreground("\u001B[34m")
    object PURPLE : Foreground("\u001B[35m")
    object CYAN : Foreground("\u001B[36m")
    object WHITE : Foreground("\u001B[37m")
    object BRIGHT_BLACK : Foreground("\u001B[30;1m")
    object BRIGHT_RED : Foreground("\u001B[31;1m")
    object BRIGHT_GREEN : Foreground("\u001B[32;1m")
    object BRIGHT_YELLOW : Foreground("\u001B[33;1m")
    object BRIGHT_BLUE : Foreground("\u001B[34;1m")
    object BRIGHT_PURPLE : Foreground("\u001B[35;1m")
    object BRIGHT_CYAN : Foreground("\u001B[36;1m")
    object BRIGHT_WHITE : Foreground("\u001B[37;1m")

    operator fun plus(background: Background) = ConsoleColorMix(this, background)
  }

  sealed class Background(ansiSequence: String) : ConsoleColor(ansiSequence) {
    object BLACK : Background("\u001B[40m")
    object RED : Background("\u001B[41m")
    object GREEN : Background("\u001B[42m")
    object YELLOW : Background("\u001B[43m")
    object BLUE : Background("\u001B[44m")
    object PURPLE : Background("\u001B[45m")
    object CYAN : Background("\u001B[46m")
    object WHITE : Background("\u001B[47m")
    object BRIGHT_BLACK : Background("\u001B[40;1m")
    object BRIGHT_RED : Background("\u001B[41;1m")
    object BRIGHT_GREEN : Background("\u001B[42;1m")
    object BRIGHT_YELLOW : Background("\u001B[43;1m")
    object BRIGHT_BLUE : Background("\u001B[44;1m")
    object BRIGHT_PURPLE : Background("\u001B[45;1m")
    object BRIGHT_CYAN : Background("\u001B[46;1m")
    object BRIGHT_WHITE : Background("\u001B[47;1m")

    operator fun plus(foreground: Foreground) = ConsoleColorMix(foreground, this)
  }

  object Reset : ConsoleColor("\u001B[0m")

  data class ConsoleColorMix(
      val foreground: Foreground,
      val background: Background
  ) : ConsoleColor(foreground.ansiSequence + background.ansiSequence)

}

fun makeColor(text: CharSequence, color: ConsoleColor) = "${color.ansiSequence}$text${Reset.ansiSequence}"

fun black(text: CharSequence) = makeColor(text, Foreground.BLACK)
fun red(text: CharSequence) = makeColor(text, Foreground.RED)
fun green(text: CharSequence) = makeColor(text, Foreground.GREEN)
fun yellow(text: CharSequence) = makeColor(text, Foreground.YELLOW)
fun blue(text: CharSequence) = makeColor(text, Foreground.BLUE)
fun purple(text: CharSequence) = makeColor(text, Foreground.PURPLE)
fun cyan(text: CharSequence) = makeColor(text, Foreground.CYAN)
fun white(text: CharSequence) = makeColor(text, Foreground.WHITE)

fun brightBlack(text: CharSequence) = makeColor(text, Foreground.BRIGHT_BLACK)
fun brightRed(text: CharSequence) = makeColor(text, Foreground.BRIGHT_RED)
fun brightGreen(text: CharSequence) = makeColor(text, Foreground.BRIGHT_GREEN)
fun brightYellow(text: CharSequence) = makeColor(text, Foreground.BRIGHT_YELLOW)
fun brightBlue(text: CharSequence) = makeColor(text, Foreground.BRIGHT_BLUE)
fun brightPurple(text: CharSequence) = makeColor(text, Foreground.BRIGHT_PURPLE)
fun brightCyan(text: CharSequence) = makeColor(text, Foreground.BRIGHT_CYAN)
fun brightWhite(text: CharSequence) = makeColor(text, Foreground.BRIGHT_WHITE)

fun blackBg(text: CharSequence) = makeColor(text, Background.BLACK)
fun redBg(text: CharSequence) = makeColor(text, Background.RED)
fun greenBg(text: CharSequence) = makeColor(text, Background.GREEN)
fun yellowBg(text: CharSequence) = makeColor(text, Background.YELLOW)
fun blueBg(text: CharSequence) = makeColor(text, Background.BLUE)
fun purpleBg(text: CharSequence) = makeColor(text, Background.PURPLE)
fun cyanBg(text: CharSequence) = makeColor(text, Background.CYAN)
fun whiteBg(text: CharSequence) = makeColor(text, Background.WHITE)

fun brightBlackBg(text: CharSequence) = makeColor(text, Background.BRIGHT_BLACK)
fun brightRedBg(text: CharSequence) = makeColor(text, Background.BRIGHT_RED)
fun brightGreenBg(text: CharSequence) = makeColor(text, Background.BRIGHT_GREEN)
fun brightYellowBg(text: CharSequence) = makeColor(text, Background.BRIGHT_YELLOW)
fun brightBlueBg(text: CharSequence) = makeColor(text, Background.BRIGHT_BLUE)
fun brightPurpleBg(text: CharSequence) = makeColor(text, Background.BRIGHT_PURPLE)
fun brightCyanBg(text: CharSequence) = makeColor(text, Background.BRIGHT_CYAN)
fun brightWhiteBg(text: CharSequence) = makeColor(text, Background.BRIGHT_WHITE)
