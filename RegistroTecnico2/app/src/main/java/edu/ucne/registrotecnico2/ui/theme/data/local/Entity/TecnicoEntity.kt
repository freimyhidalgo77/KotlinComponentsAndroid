package edu.ucne.registrotecnico2.ui.theme.data.local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tecnicos")
data class TecnicoEntity(
    @PrimaryKey(autoGenerate = true)
    val tecnicoId: Int? = null,
    val nombre: String = "",
    val sueldo: Double = 0.0
)

