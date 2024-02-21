# Итоговая контрольная работа
(20 февраля 2024 года, студент — С.А. Грубов, группа № 4828)

_Необходимо организовать систему учета для питомника в котором живут домашние и Pack animals._


### Операционные системы и виртуализация (Linux)

___

#### 1. Использование команды cat в Linux
- Создать два текстовых файла: "Pets"(Домашние животные) и "Pack animals"(вьючные животные), 
используя команду `cat` в терминале Linux. В первом файле перечислить собак, кошек и хомяков. 
Во втором — лошадей, верблюдов и ослов.
- Объединить содержимое этих двух файлов в один и просмотреть его содержимое.
- Переименовать получившийся файл в "Human Friends".


**_Команды:_**
```
$ cat > pets.txt 
$ cat > pack_animals.txt
$ cat pets.txt pack_animals.txt > all_animals.txt
$ cat all_animals.txt
$ mv all_animals.txt human_friends.txt
```
**_Вывод:_**

![1](/img/1.JPG)
___

#### 2. Работа с директориями в Linux
- Создать новую директорию и переместить туда файл "Human Friends".

**_Команды:_**
```
$ mkdir animals
$ mv human_friends.txt animals
```
**_Вывод:_**

![2](/img/2.JPG)
___

#### 3. Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную машину ”
- Подключить дополнительный репозиторий MySQL и установить один из пакетов из этого репозитория.

**_Команды:_**
```
$ sudo apt update
$ sudo apt install gnupg
$ cd /tmp
$ wget https://dev.mysql.com/get/mysql-apt-config_0.8.24-1_all.deb
$ ll
$ sudo dpkg -i mysql-apt-config*
$ sudo apt update
$ sudo apt install mysql-server
$ sudo systemctl status mysql
```
**_Вывод:_**

![3_1](/img/3_1.JPG)
![3_2](/img/3_2.JPG)
![3_3](/img/3_3.JPG)
![3_4](/img/3_4.JPG)
___

#### 4. Управление deb-пакетами
- Установить и затем удалить deb-пакет, используя команду `dpkg`.

**_Команды:_**
```
$ sudo dpkg -i mysql-apt-config_0.8.24-1_all.deb
$ sudo dpkg -r mysql-apt-config
$ sudo dpkg --purge mysql-apt-config
```
**_Вывод:_**

![4](/img/4.JPG)
___

#### 5. История команд в терминале Ubuntu
- Сохранить и выложить историю ваших терминальных команд в Ubuntu. 
В формате: Файла с ФИО, датой сдачи, номером группы (или потока)

**_Команды:_**
```
$ history
```
**_Вывод:_**

![5](/img/5.JPG)
___

### Объектно-ориентированное программирование

#### 6. Диаграмма классов

- Создать диаграмму классов с родительским классом "Животные", и двумя подклассами: 
"Pets" и "Pack animals". 
- В составы классов которых в случае Pets войдут классы: 
собаки, кошки, хомяки, а в класс Pack animals войдут: Лошади, верблюды и ослы). 
- Каждый тип животных будет характеризоваться (например, имена, даты рождения, 
выполняемые команды и т.д). 
- Диаграмму можно нарисовать в любом редакторе, такими как Lucidchart, Draw.io, Microsoft Visio и других.

**_Вывод:_**

![6](/img/6.JPG)
___

#### 7. Работа с MySQL 
_(Задача выполняется в случае успешного выполнения задачи “Работа с MySQL в Linux. “Установить MySQL на вашу машину”)_

___

##### 7.1. После создания диаграммы классов в 6 пункте, в 7 пункте база данных "Human Friends" должна быть структурирована в соответствии с этой диаграммой. Например, можно создать таблицы, которые будут соответствовать классам "Pets" и "Pack animals", и в этих таблицах будут поля, которые характеризуют каждый тип животных (например, имена, даты рождения, выполняемые команды и т.д.).

___

##### 7.2. В ранее подключенном MySQL создать базу данных с названием "Human Friends".
- Создать таблицы, соответствующие иерархии из вашей диаграммы классов.

**_Команды:_**

```
CREATE DATABASE human_friends;
USE human_friends;

CREATE TABLE commands
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30),
    description varchar(255)
);

CREATE TABLE animals_group
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30)
);

CREATE TABLE animal_genius
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30),
    group_id INT,
    FOREIGN KEY (group_id) REFERENCES animals_group (id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE nursery_animal
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30),
    birth_date DATE,
    genius_id INT,
    FOREIGN KEY (genius_id) REFERENCES animal_genius (id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE animal_commands
(
    animal_id INT NOT NULL,
    command_id INT NOT NULL,

    PRIMARY KEY (animal_id, command_id),
    FOREIGN KEY (animal_id) REFERENCES nursery_animal (id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (command_id) REFERENCES commands (id)
    ON DELETE CASCADE  ON UPDATE CASCADE
);
```
**_Вывод:_**

![7_2_1](/img/7_2_1.JPG)
___


- Заполнить таблицы данными о животных, их командах и датами рождения.

**_Команды:_**

```
INSERT INTO commands(name)
VALUES
	 ('Поймать мышь'),
	 ('Бегать'),
	 ('Прыжок'),
	 ('Мурлыкать'),
	 ('Плеваться');

INSERT INTO animals_group (name)
VALUES
	 ('Вьючные животные'),
	 ('Домашние животные');

INSERT INTO animal_genius (name, group_id)
VALUES
	 ('Кошка', 2),
	 ('Собака', 2),
	 ('Хомяк', 2),
	 ('Лошадь', 1),
	 ('Осел', 1),
	 ('Верблюд', 1);

INSERT INTO nursery_animal (name, birth_date, genius_id)
VALUES
	 ('Гизма', '2019-01-11', 1),
	 ('Шаня', '2016-03-14', 2),
	 ('Мелкий', '2024-01-01', 3),
	 ('Айвенго', '2021-02-04', 4),
	 ('Ванда', '2022-12-01', 4),
	 ('Иа', '2018-08-24', 5),
	 ('Боря', '2023-05-20', 6);

INSERT INTO animal_commands (animal_id, command_id)
VALUES
	 (1, 1), (1, 4), (2, 1), (2, 4),
	 (3, 3), (4, 3), (5, 5), (6, 2),
	 (7, 1), (7, 4);
```
**_Вывод:_**

![7_2_2](/img/7_2_2.JPG)
___

- Удалить записи о верблюдах и объединить таблицы лошадей и ослов.

**_Команды:_**

```
DELETE FROM nursery_animal WHERE genius_id = 6;

CREATE TABLE horse_donkey AS
SELECT * from nursery_animal WHERE genius_id = 4
UNION
SELECT * from nursery_animal WHERE genius_id = 5;
```
**_Вывод:_**

![7_2_3](/img/7_2_3.JPG)
___

- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.

**_Команды:_**

```
CREATE TABLE young_animals AS
SELECT id, name, birth_date,
datediff(curdate(),birth_date) DIV 31 as age, genius_id
from nursery_animal
WHERE date_add(birth_date, INTERVAL 1 YEAR) < curdate()
AND date_add(birth_date, INTERVAL 3 YEAR) > curdate();
```

**_Вывод:_**

![7_2_4](/img/7_2_4.JPG)
___

- Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.

**_Команды:_**

```
SELECT id, name, birth_date, genius_id FROM horse_donkey
UNION
SELECT id, name, birth_date, genius_id FROM young_animals;
```

**_Вывод:_**

![7_2_5](/img/7_2_5.JPG)
___

#### 8. ООП и Java
- Создать иерархию классов в Java, который будет повторять диаграмму классов созданную в задаче 6 (Диаграмма классов).

___

#### 9. Программа-реестр домашних животных
- [Написать программу на Java](https://github.com/Sergei-grub/Control_Java_Linux_SQL/tree/e5a05216a4843973d4c3c66e11406fe5932d88e1/JavaAnimals), которая будет имитировать реестр домашних животных. 
Должен быть реализован следующий функционал:

  ##### 9.1. Добавление нового животного
   - Реализовать функциональность для добавления новых животных в реестр. 
Животное должно определяться в правильный класс (например, "собака", "кошка", "хомяк" и т.д.)
  
  ##### 9.2. Список команд животного
  - Вывести список команд, которые может выполнять добавленное животное (например, "сидеть", "лежать").
  
  ##### 9.3. Обучение новым командам
  - Добавить возможность обучать животных новым командам.

  ##### 9.4 Вывести список животных по дате рождения

  ##### 9.5. Навигация по меню
  - Реализовать консольный пользовательский интерфейс с меню для навигации между вышеуказанными функциями.

___

#### 10. Счетчик животных
- Создать механизм, который позволяет вывести на экран общее количество созданных животных 
любого типа (Как домашних, так и вьючных), то есть при создании каждого нового животного 
счетчик увеличивается на “1”.

**_Вывод:_**

![9_10](/img/9_10.JPG)