class Student:
    def __init__(self, rank, attendance, num):
        self.rank = rank
        self.attendance = attendance
        self.num = num


def solution(rank, attendance):
    student_list = []
    for i, r in enumerate(rank):
        student_list.append(Student(r, attendance[i], i))

    l = sorted(student_list, key=lambda x: x.rank)

    result = []

    for student in l:
        if student.attendance:
            result.append(student.num)
        if len(result) == 3:
            break

    return result[0] * 10000 + result[1] * 100 + result[2]