Простой движок для создания онлайн квизов и проверки решений

#Доступные операции:

POST
/api/quizzes
Принимает JSON вида
{
  "title": "example",
  "text": "Choose options",
  "options": ["one","two","three","four"],
  "answer": [0, 1, 2, 3]
}
Присваивает квизу id, добавляет в базу и возвращает без options.
title и text не пустые, options больше одного, иначе возвращает Bad Request.

POST /quizzes/{id}/solve
Принимает JSON {"answer": [0, 1, 2, 3]}
Сравнивает с данными в базе и возвращает JSON
{"success": boolean,"feedback":"text"}
Если квиза с таким id нет, возвращает 404.

GET
/api/quizzes
Возвращает все созданные квизы в виде JSON без ответов

GET
/quizzes/{id}
Возвращает квиз по id в виде JSON или 404, если квиза с таким id нет.

TODO:
Авторизация
Представления
Тесты
Спецификация
