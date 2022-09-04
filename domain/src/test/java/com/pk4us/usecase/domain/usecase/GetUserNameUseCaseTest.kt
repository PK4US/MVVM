package com.pk4us.usecase.domain.usecase

import com.pk4us.usecase.domain.models.UserName
import com.pk4us.usecase.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetUserNameUseCaseTest{

    private val userRepository = mock<UserRepository>()

    @Test
    fun `should Return Correct Data`() {

        val testUserName = UserName(firstName = "test firstName", lastName = "test lastName")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = GetUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute()
        val expected = UserName(firstName = "test firstName", lastName = "test lastName")

        Assertions.assertEquals(expected, actual)
    }
}