package org.rishirajput.weatherkmp.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import weather.composeapp.generated.resources.Res
import weather.composeapp.generated.resources.poppins_black
import weather.composeapp.generated.resources.poppins_black_italic
import weather.composeapp.generated.resources.poppins_bold
import weather.composeapp.generated.resources.poppins_bold_italic
import weather.composeapp.generated.resources.poppins_extra_bold
import weather.composeapp.generated.resources.poppins_extra_bold_italic
import weather.composeapp.generated.resources.poppins_extra_light
import weather.composeapp.generated.resources.poppins_extra_light_italics
import weather.composeapp.generated.resources.poppins_italic
import weather.composeapp.generated.resources.poppins_light
import weather.composeapp.generated.resources.poppins_light_italic
import weather.composeapp.generated.resources.poppins_medium
import weather.composeapp.generated.resources.poppins_medium_italic
import weather.composeapp.generated.resources.poppins_regular
import weather.composeapp.generated.resources.poppins_semi_bold
import weather.composeapp.generated.resources.poppins_semi_bold_italic
import weather.composeapp.generated.resources.poppins_thin
import weather.composeapp.generated.resources.poppins_thin_italic

@Composable
fun providePoppinsFontFamily(): FontFamily {
    return FontFamily(
        Font(Res.font.poppins_thin, FontWeight.Thin),
        Font(Res.font.poppins_extra_light, FontWeight.ExtraLight),
        Font(Res.font.poppins_light, FontWeight.Light),
        Font(Res.font.poppins_regular, FontWeight.Normal),
        Font(Res.font.poppins_medium, FontWeight.Medium),
        Font(Res.font.poppins_semi_bold, FontWeight.SemiBold),
        Font(Res.font.poppins_bold, FontWeight.Bold),
        Font(Res.font.poppins_extra_bold, FontWeight.ExtraBold),
        Font(Res.font.poppins_black, FontWeight.Black),
        Font(Res.font.poppins_thin_italic, FontWeight.Thin),
        Font(Res.font.poppins_extra_light_italics, FontWeight.ExtraLight),
        Font(Res.font.poppins_light_italic, FontWeight.Light),
        Font(Res.font.poppins_italic, FontWeight.Normal),
        Font(Res.font.poppins_medium_italic, FontWeight.Medium),
        Font(Res.font.poppins_semi_bold_italic, FontWeight.SemiBold),
        Font(Res.font.poppins_bold_italic, FontWeight.Bold),
        Font(Res.font.poppins_extra_bold_italic, FontWeight.ExtraBold),
        Font(Res.font.poppins_black_italic, FontWeight.Black)
    )
}



@Composable
fun provideAppTypography(): Typography {
    val poppinsFontFamily = providePoppinsFontFamily()
    return Typography(
        bodyLarge = TextStyle(
            fontFamily = poppinsFontFamily,
            fontSize = 15.sp,
            fontWeight = FontWeight.W400,
            lineHeight = 22.5.sp,
            textAlign = TextAlign.Start,
        ),
        headlineMedium = TextStyle(
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        // Define other text styles as needed
    )
}

@Composable
fun provideTextStyleCityName(): TextStyle {
    val poppinsFontFamily = providePoppinsFontFamily()
    return TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 30.sp,
        fontWeight = FontWeight.W600,
        lineHeight = 45.sp,
        textAlign = TextAlign.Center,
        color = appFontColor
    )
}

@Composable
fun provideTextStyleSearchCityLabel(): TextStyle {
    val poppinsFontFamily = providePoppinsFontFamily()
    return TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 15.sp,
        fontWeight = FontWeight.W600,
        lineHeight = 22.5.sp,
        textAlign = TextAlign.Center,
        color = appFontColor
    )
}

@Composable
fun provideTextStyleLocationName(): TextStyle {
    val poppinsFontFamily = providePoppinsFontFamily()
    return TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.W600,
        lineHeight = 30.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun provideTextStyleCurrentTemperature(): TextStyle {
    val poppinsFontFamily = providePoppinsFontFamily()
    return TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 60.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 90.sp,
        textAlign = TextAlign.Left,
    )
}

@Composable
fun provideTextStyleTemperatureLarge(): TextStyle {
    val poppinsFontFamily = providePoppinsFontFamily()
    return TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 70.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 105.sp,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun provideTextStyleMedium(): TextStyle {
    val poppinsFontFamily = providePoppinsFontFamily()
    return TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 15.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 22.5.sp,
        textAlign = TextAlign.Center,
        color = appFontColorHeavy
    )
}

@Composable
fun provideTextStyleSmall(): TextStyle {
    val poppinsFontFamily = providePoppinsFontFamily()
    return TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 18.sp,
        textAlign = TextAlign.Center,
        color = onSurfaceColor
    )
}