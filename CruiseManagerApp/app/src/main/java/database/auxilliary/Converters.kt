package database.auxilliary

import androidx.room.TypeConverter
import database.customDataTypes.RainFallState
import database.customDataTypes.SailState
import database.customDataTypes.WindDirection

class Converters {
    @TypeConverter
    fun fromSailStateToInt(value: SailState?): Int? {
        return when(value){
            SailState.UNSET -> 0
            SailState.FIRST_REF -> 1
            SailState.SECOND_REF -> 2
            SailState.FULLY_SET -> 3
            else -> 4
        }
    }

    @TypeConverter
    fun fromIntToSailState(value: Int?): SailState? {
        return when(value){
            0 -> SailState.UNSET
            1 -> SailState.FIRST_REF
            2 -> SailState.SECOND_REF
            3 -> SailState.FULLY_SET
            else -> SailState.NOT_GIVEN
        }
    }

    @TypeConverter
    fun fromWindDirectionToDouble(value: WindDirection?): Double? {
        return when(value){
            WindDirection.NORTH -> 0.0
            WindDirection.NORTH_WEST -> 315.0
            WindDirection.NORTH_EAST -> 45.0
            WindDirection.WEST -> 270.0
            WindDirection.EAST -> 90.0
            WindDirection.SOUTH_WEST -> 225.0
            WindDirection.SOUTH_EAST -> 135.0
            WindDirection.SOUTH -> 180.0
            else -> 361.0
        }
    }

    @TypeConverter
    fun fromDoubleToWindDirection(value: Double?): WindDirection? {
        return when(value){
            0.0 -> WindDirection.NORTH
            315.0 -> WindDirection.NORTH_WEST
            45.0 -> WindDirection.NORTH_EAST
            270.0 -> WindDirection.WEST
            90.0 -> WindDirection.EAST
            225.0 -> WindDirection.SOUTH_WEST
            135.0 -> WindDirection.SOUTH_EAST
            180.0 -> WindDirection.SOUTH
            else -> WindDirection.NOT_GIVEN
        }
    }

    @TypeConverter
    fun fromRainStateToInt(value: RainFallState?): Int? {
        return when(value){
            RainFallState.NONE -> 0
            RainFallState.LITTLE_RAIN -> 1
            RainFallState.NORMAL_RAIN -> 2
            RainFallState.HEAVY_RAIN -> 3
            RainFallState.SNOW -> 4
            RainFallState.SNOW_AND_RAIN -> 5
            RainFallState.FOG -> 6
            RainFallState.HAILSTONES -> 7
            RainFallState.HOARFROST -> 8
            else -> 9
        }
    }

    @TypeConverter
    fun fromRainStateToInt(value: Int?):RainFallState? {
        return when(value){
            0 -> RainFallState.NONE
            1 -> RainFallState.LITTLE_RAIN
            2 -> RainFallState.NORMAL_RAIN
            3 -> RainFallState.HEAVY_RAIN
            4 -> RainFallState.SNOW
            5 -> RainFallState.SNOW_AND_RAIN
            6 -> RainFallState.FOG
            7 -> RainFallState.HAILSTONES
            8 -> RainFallState.HOARFROST
            else -> RainFallState.NO_INFO
        }
    }


}