package classes

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.DayOfWeek
import java.time.LocalDate
import java.util.Date

data class DayOfOrders (
    val date: String,                   // Заменяем Date на LocalDate (KMP-совместимый)
    val dayOfTheWeek: String,              // Сохраняем как есть
    val orders: List<Order> = emptyList()   // Делаем List вместо MutableList
) {
    // Оптимизированный конструктор для автоматического определения дня недели


    // Метод для добавления заказа (возвращает новый объект)
    fun withOrder(order: Order): DayOfOrders {
        return copy(orders = orders + order)
    }

    // Метод для удаления заказа
    fun withoutOrder(orderId: String): DayOfOrders {
        return copy(orders = orders.filter { it.id != orderId })
    }
}