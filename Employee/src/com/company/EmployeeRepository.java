package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EmployeeRepository {

    private final List<Employee> employees;

    public EmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Найти всех сотрудников с заданной фамилией
     */
    public List<Employee> getByLastName(String lastName) {
        List<Employee> result = new LinkedList<>();
        for (var current : employees) {
            if (lastName.equals(current.getFio().getLastName())) {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников старше заданного возраста
     */
    public List<Employee> getOlderThan(int age) {
        List<Employee> result = new LinkedList<>();
        for (var current : employees) {
            if (current.getAge() > age) {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников заданного пола.
     * Вместо Object используйте ваш класс для пола
     */
    public List<Employee> getByGender(Sex sex) {
        List<Employee> result = new LinkedList<>();
        for (var current : employees) {
            if (current.getSex() == sex) {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников с указанными должностями
     */
    public List<Employee> getByStates(String... states) {
        List<Employee> result = new LinkedList<>();
        for (int i = 0; i < states.length; i++) {
            for (int j = 0; j < employees.size(); j++) {
                if (states[i].equals(employees.get(j).getPost())) {
                    result.add(employees.get(j));
                }
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников с зарплатой меньше заднной в рублях
     */
    public List<Employee> getBySalaryLessThan(int salaryInRubbles) {
        List<Employee> result = new LinkedList<>();
        for (var current : employees) {
            if (current.getSalary().intValue() < salaryInRubbles) {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников, обладающих заданным навыком
     */
    public List<Employee> getBySkill(String skill) {
        List<Employee> result = new LinkedList<>();
        for (var current : employees) {
            if (current.getSkills().contains(skill)) {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников, работающих в компании больше заданного числа лет
     */
    public List<Employee> getWorkMoreThan(int years) {
        List<Employee> result = new LinkedList<>();
        for (var current : employees) {
            if (LocalDate.now().compareTo(current.getDataOfStart()) > years) {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников, у которых День рождения в указанную дату
     */
    public List<Employee> getBirthDayMates(LocalDate date) {
        List<Employee> result = new LinkedList<>();
        for (var current : employees) {
            if (current.getBirthDate().equals(date)) {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Получить сколько всего сотрудников работает в компании
     */
    public int amount() {
        return employees.size();
    }

    /**
     * Получить сколько всего денег тратит компания на зарплаты в год.
     * Вместо Object используйте подходящий тип данных
     */
    public BigDecimal totalSalary() {
        List<BigDecimal> result = new LinkedList<>();
        for (var current : employees) {
            result.add(current.getSalary());
        }
        return result.stream().reduce(BigDecimal.ZERO, BigDecimal::add).multiply(new BigDecimal(12));
    }

    /**
     * Получить отображение идентификатора работника на сущность работника для удобства дальнейшего поиска по id
     */
    public Map<Integer, Employee> mapIdToEmployee() {
        Map<Integer, Employee> result = new HashMap<Integer, Employee>();
        for (var current : employees) {
            result.put(current.getId(), current);
        }
        return result;
    }
    @Override
    public String toString(){
        return employees.toString();
    }
}
