package com.example.tukuypacandroid.data

import com.example.tukuypacandroid.data.model.MedicalGroup
import com.example.tukuypacandroid.data.model.Plant

class Seed {
    fun getAllGroups(): List<MedicalGroup> {
        return listOf(
            MedicalGroup(1, "Nervioso"),
            MedicalGroup(2, "Digestivo"),
            MedicalGroup(
                3,
                "limpieza sangre"
            ),
            MedicalGroup(
                4,
                "Elevan defensas"
            )
        )
    }

    fun getAllPant(): List<Plant> {
        return listOf(
            Plant(
                1,
                "La Muña Andina",
                2,
                "La Muña Andina es un planta que crece en los valles interandinos del Perú, su uso se remonta a épocas pre – hispánicas, convirtiéndose en un remedio natural de invaluable valor cultural.\n" +
                        "\n" +
                        "El consumo tradicional de la muña para remediar estas afecciones se da a través de la infusión o mate,  ya que de esta forma se logra extraer sus propiedades carminativas y estomacales con una mayor eficacia.  No obstante su suave sabor a menta ha sido dedicado también a la condimentación y aromatización de los platos culinarios de la serranía suramericana desde hace siglos.",
                "munaandina.jpg"
            ),
            Plant(
                2,
                "Toronjil",
                1,
                "El menta, limoncillo, la melisa u hoja de limón\u200B (Melissa officinalis) es una hierba perenne de la familia de las lamiáceas, nativa del sur de Europa y de la región mediterránea. Apreciada por su fuerte aroma a limón, se utiliza en infusión como tranquilizante natural, y su aceite esencial se aprovecha en perfumería.\n",
                "toronjil.jpg"
            ),
            Plant(
                3,
                "Lluvia de oro",
                3,
                "Es un arbusto de corteza lisa, con ramas colgantes y ramitas pubescentes. Las hojas tienen un largo pedúnculo, son lisas en el haz y vellosas por el envés . Las flores son de color amarillo dorado y dulce aroma, que se agrupan en racimos colgantes de 25 cm de largo, y normalmente florecen en mayo. Los frutos son legumbres con un gran número de semillas de color negro que contienen citisina, un alcaloide extremadamente tóxico no solo para los seres humanos sino también para los caballos, sobre todo cuando no están maduras. Sin embargo, algunos animales salvajes como liebres y ciervos puede alimentar en ellos sin ningún problema. La madera es dura y pesada , de un color amarillo- marrón, ideal para el torneado de madera y como combustible. En el pasado (y hoy en la recreación histórica), fue utilizado para hacer arcos.\n",
                "lluviadeoro.jpg"
            ),
            Plant(
                4,
                "Wira wira",
                4,
                "A esta plantita conocida como remedio para la tos, en todas partes se le da el nombre de Wira Wira o Vira Vira. Esta hierba tiene actividad comprobada como antibiótico contra bacterias y virus.",
                "wirawira.jpg"
            )
//            Plant(3, "", 1, "", ""),
        )
    }
}