def calculate(string_calculation):
    if "+" in string_calculation:
        number_list = string_calculation.split("+")
        result = 0
        for number in number_list:
            result += int(number)

        return result
    return int(string_calculation)


def test_input_number_string_returns_number():
    assert calculate("1") == 1
    assert calculate("345") == 345
    assert calculate("-1") == -1


def test_input_addition_calculation_string_returns_sum_of_numbers():
    assert calculate("1+1") == 2
    assert calculate("1+2") == 3
