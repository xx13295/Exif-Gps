::[Bat To Exe Converter]
::
::YAwzoRdxOk+EWAjk
::fBw5plQjdCuDJHCg0WN9HxRGRxeSPWi/OrMEpez+4uW7tkwPU+crRIDOzqSbNPoa+nnmfJgR2nVdl4UFDxQ4
::YAwzuBVtJxjWCl3EqQJgSA==
::ZR4luwNxJguZRRnk
::Yhs/ulQjdF+5
::cxAkpRVqdFKZSzk=
::cBs/ulQjdF+5
::ZR41oxFsdFKZSDk=
::eBoioBt6dFKZSDk=
::cRo6pxp7LAbNWATEpCI=
::egkzugNsPRvcWATEpCI=
::dAsiuh18IRvcCxnZtBJQ
::cRYluBh/LU+EWAnk
::YxY4rhs+aU+IeA==
::cxY6rQJ7JhzQF1fEqQJhZksaHErSXA==
::ZQ05rAF9IBncCkqN+0xwdVsFAlTMbCXqZg==
::ZQ05rAF9IAHYFVzEqQK4z9HRgv4G5YI+2XuaHDHc39nn
::eg0/rx1wNQPfEVWB+kM9LVsJDGQ=
::fBEirQZwNQPfEVWB+kM9LVsJDGQ=
::cRolqwZ3JBvQF1fEqQK4z9HRgv4G5YI+2XuaHDF+FDQAS6qbogW7o1n+4p2opxr3zXXX8UnsUJuVFxfgif29+c9l6tLrLpqKs3yMMdOTvAOB
::dhA7uBVwLU+EWN9sBcXKzJOOh4xc5e5V9zLoF2whCWxwYsvOoWTcqwcKGzN0xGfyNMweq/Y=
::YQ03rBFzNR3SWATE/FYkOAgOA0uNNmmxSKUQ/fub
::dhAmsQZ3MwfNWATE41o9SA==
::ZQ0/vhVqMQ3MEVWAtB9wSA==
::Zg8zqx1/OA3MEVWAtB9wSA==
::dhA7pRFwIByZRRnk
::Zh4grVQjdCuDJHCg0WN9HxRGRxeSPWi/OrMEpez+4uW7tkwPU+crRIDOzqSbNPoa+nnmfJgRXp2QHQX2iMKxWSKYIAosrA4=
::YB416Ek+ZG8=
::
::
::978f952a14a936cc963da21a135fa983
@echo off
set myPath=%~dp0
set PATH=%PATH%;%myPath%;
set JLINK_VM_OPTIONS=
set DIR=%~dp0
"%DIR%\java" %JLINK_VM_OPTIONS% -m plus.ojbk.fxdemo/plus.ojbk.exif.ExifApplication %*
