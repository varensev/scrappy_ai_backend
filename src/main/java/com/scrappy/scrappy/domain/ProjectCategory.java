package com.scrappy.scrappy.domain;

import lombok.Getter;

@Getter
public enum ProjectCategory {
    OFFICE("office", "Офисная деятельность", "🏢", new String[]{"офис", "документы", "встречи", "отчеты", "планы"}),
    RESTAURANT("restaurant", "Ресторанная деятельность", "🍽️", new String[]{"меню", "персонал", "заказы", "кухня", "обслуживание"}),
    PERSONAL("personal", "Личный проект", "🧘", new String[]{"цели", "хобби", "развитие", "здоровье", "спорт"}),
    LOGISTICS("logistics", "Логистика", "🚚", new String[]{"доставка", "склад", "транспорт", "маршруты", "грузы"}),
    PLANNER("planner", "Планер задач", "📌", new String[]{"задачи", "дедлайны", "проекты"}),
    ASSISTANT("assistant", "Личный ассистент", "📅", new String[]{"напоминания", "расписание", "контакты", "заметки", "автоматизация"}),
    EDUCATION("education", "Образование", "🎓", new String[]{"обучение", "курсы", "студенты", "материалы", "экзамены"}),
    CREATIVE("creative", "Творческие проекты", "🎨", new String[]{"дизайн", "контент", "медиа", "искусство", "креатив"}),
    HEALTHCARE("healthcare", "Здравоохранение", "🏥", new String[]{"пациенты", "медкарты", "процедуры", "лечение"});

    private final String id;
    private final String name;
    private final String icon;
    private final String[] tags;

    ProjectCategory(String id, String name, String icon, String[] tags) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.tags = tags;
    }
}