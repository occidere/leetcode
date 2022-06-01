from setuptools import setup, find_packages

setup(
	version='1.0.0',
	name='analysis',
	url='https://github.com/occidere/leetcode',
	description='LeetCode solve status analysis',
	packages=find_packages(exclude=['tests', 'docs']),
	package_data={'': ['resources/*.yaml']},
	include_package_data=True,
	python_requires='>=3.6',
	zip_safe=False,
	classifiers=[
		"Programming Language :: Python",
		"Programming Language :: Python :: 3",
		"Programming Language :: Python :: 3.6",
		"Programming Language :: Python :: 3.7",
		"Programming Language :: Python :: 3.8",
		"Programming Language :: Python :: 3.9",
		"Programming Language :: Python :: 3.10",
	],
	install_requires=[
		'PyYAML',
		'requests',
		'matplotlib',
		'pytz',
	]
)
